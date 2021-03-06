package com.sensedia.apix2019.kit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.apix2019.kit.config.JsonConfig;
import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Recommendation;
import com.sensedia.apix2019.kit.entity.Specification;
import com.sensedia.apix2019.kit.exception.PreconditionFailedException;
import com.sensedia.apix2019.kit.exception.ResourceNotFoundException;
import com.sensedia.apix2019.kit.repository.KitRepository;
import com.sensedia.apix2019.kit.repository.RecommendationRepository;
import com.sensedia.apix2019.kit.request.KitRequest;
import com.sensedia.apix2019.kit.request.RecommendationRequest;
import com.sensedia.apix2019.kit.request.RecommendationsPatchRequest;
import com.sensedia.apix2019.kit.response.KitResponse;
import com.sensedia.apix2019.kit.sender.KitSender;
import com.sensedia.apix2019.kit.request.NotificationRequest;

@Service
public class KitService {

    @Autowired
    private KitRepository kitRepository;

    @Autowired
    private KitSender kitSender;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private JsonConfig jsonConfig;

    public String create(KitRequest kitRequest) {

        if (kitRequest.getSpecifications().size() != 3) {
            throw new PreconditionFailedException("Number of spacifications are invalid.");
        }

        Kit entity = kitRequest.toEntity();
        if (entity.getSpecifications().stream().map(Specification::getType).distinct().count() != 3) {
            throw new PreconditionFailedException("There are duplicated types of specifications");
        }

        kitRepository.save(entity);
        String kitJson = jsonConfig.toJson(entity.toQueue());
        kitSender.sendToCrawler(kitJson);

        return entity.getId();
    }

    public KitResponse findById(String id) {
        return kitRepository.findById(id)
                .map(Kit::toResponse)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<KitResponse> findByPhone(String phone) {
        return kitRepository.findByPhone(phone).stream()
                .map(Kit::toResponse)
                .collect(Collectors.toList());

    }

    public void createRecommendation(RecommendationRequest recommendationRequest) {
        Kit kit = kitRepository.findById(recommendationRequest.getId()).orElseThrow(ResourceNotFoundException::new);
        List<Recommendation> recommendations = new ArrayList<>();
        AtomicInteger kitGroup = new AtomicInteger();
        recommendationRequest.getRecommendations().forEach(recommendation -> {
            recommendation.forEach(item -> {
                Recommendation entity = item.toEntity(kit, kitGroup.get());
                recommendations.add(entity);
            });
            kitGroup.incrementAndGet();
        });
        recommendationRepository.saveAll(recommendations);

        sendToNotification(kit.getPhone(), recommendationRequest.getRecommendations().size());
    }

    private void sendToNotification(String phone, Integer recommendationsCount) {
        NotificationRequest notificationRequest = new NotificationRequest(phone, recommendationsCount);
        kitSender.sendToNotification(jsonConfig.toJson(notificationRequest));
    }

    public void updateSelectedRecommendations(String kitId, RecommendationsPatchRequest recommendationsPatchRequest) {
        Kit kit = kitRepository.findById(kitId).orElseThrow(ResourceNotFoundException::new);
        kit.getRecommendations()
                .forEach(recommendation -> recommendationsPatchRequest.getRecommendations().forEach(id -> {
                    if (recommendation.getKitGroup() == id.getId()) {
                        recommendation.setChosen(true);
                    }
                }));

        recommendationRepository.saveAll(kit.getRecommendations());
    }

}
