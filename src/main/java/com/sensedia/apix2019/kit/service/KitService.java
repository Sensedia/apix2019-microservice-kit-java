package com.sensedia.apix2019.kit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
import com.sensedia.apix2019.kit.response.KitResponse;
import com.sensedia.apix2019.kit.sender.KitSender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KitService {

    private final KitRepository kitRepository;
    private final KitSender kitSender;
    private final RecommendationRepository recommendationRepository;
    private final JsonConfig jsonConfig;

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
        kitSender.send(kitJson);

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
    }

}
