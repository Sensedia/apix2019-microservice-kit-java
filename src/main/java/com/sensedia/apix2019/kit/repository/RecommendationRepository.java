package com.sensedia.apix2019.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensedia.apix2019.kit.entity.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, String> {

}
