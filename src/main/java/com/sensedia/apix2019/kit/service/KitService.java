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
import com.sensedia.apix2019.kit.exception.ResourceNotFoundException;
import com.sensedia.apix2019.kit.repository.KitRepository;
import com.sensedia.apix2019.kit.repository.RecommendationRepository;
import com.sensedia.apix2019.kit.request.KitRequest;
import com.sensedia.apix2019.kit.request.NotificationRequest;
import com.sensedia.apix2019.kit.request.RecommendationRequest;
import com.sensedia.apix2019.kit.request.RecommendationsPatchRequest;
import com.sensedia.apix2019.kit.response.KitResponse;
import com.sensedia.apix2019.kit.sender.KitSender;

@Service
public class KitService {

	// Dica: esses caras que já estão injetados são muito importantes!
	
    @Autowired
    private KitRepository kitRepository;

    @Autowired
    private KitSender kitSender;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private JsonConfig jsonConfig;

    public String create(KitRequest kitRequest) {

        // implementar a persistência desta bagaça
    	return null;
    }

    public List<KitResponse> findByPhone(String phone) {
    	
    	// implementar busca por phone
        return null;
    }

    public void createRecommendation(RecommendationRequest recommendationRequest) {
    	// implementar a persistência desta outra bagaça
    }

    public void updateSelectedRecommendations(String kitId, RecommendationsPatchRequest recommendationsPatchRequest) {
        // implementar update
    }
    
    public KitResponse findById(String id) {
        return kitRepository.findById(id)
                .map(Kit::toResponse)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
