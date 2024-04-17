package com.github.gungor.service;

import com.github.gungor.model.FeatureCreateRequest;
import com.github.gungor.persistence.entity.Feature;

import java.util.List;

public interface FeatureService {

    void saveFeature(FeatureCreateRequest request);

    List<Feature> getFeatures();
}
