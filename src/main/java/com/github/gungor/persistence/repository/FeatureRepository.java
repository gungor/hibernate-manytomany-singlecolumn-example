package com.github.gungor.persistence.repository;

import com.github.gungor.persistence.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
