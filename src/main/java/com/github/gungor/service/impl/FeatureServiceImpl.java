package com.github.gungor.service.impl;

import com.github.gungor.model.FeatureCreateRequest;
import com.github.gungor.persistence.entity.Feature;
import com.github.gungor.persistence.repository.FeatureRepository;
import com.github.gungor.service.FeatureService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    private FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public void saveFeature(FeatureCreateRequest request) {
        Feature feature = new Feature(null, request.getName());
        featureRepository.save(feature);
    }

    @Override
    @Cacheable(value = "features")
    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }
}
