package com.sensedia.apix2019.kit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Recommendation;
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

    public String create(KitRequest kitRequest) {
        Kit entity = kitRepository.save(kitRequest.toEntity());
        kitSender.send(entity.toResponse().toString());
        return entity.getId();
    }

    public KitResponse findById(String id) {
        return kitRepository.findById(id)
                .map(Kit::toResponse)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void createRecommendation(String id, RecommendationRequest recommendationRequest) {
        Kit kit = kitRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        List<Recommendation> recommendations = new ArrayList<>();
        AtomicInteger kitGroup = new AtomicInteger();
        recommendationRequest.getFirstRecommendations().stream().forEach(item -> {
            Recommendation entity = item.toEntity(kit, kitGroup.get());
            recommendations.add(entity);
        });
        kitGroup.incrementAndGet();
        recommendationRequest.getSecondRecommendations().stream().forEach(item -> {
            Recommendation entity = item.toEntity(kit, kitGroup.get());
            recommendations.add(entity);
        });
        kitGroup.incrementAndGet();
        recommendationRequest.getThirdRecommendations().stream().forEach(item -> {
            Recommendation entity = item.toEntity(kit, kitGroup.get());
            recommendations.add(entity);
        });

        recommendationRepository.saveAll(recommendations);
    }

}
