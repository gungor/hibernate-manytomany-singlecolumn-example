package com.github.gungor.service.impl;


import com.github.gungor.model.EstablishmentCreateRequest;
import com.github.gungor.model.EstablishmentResponse;
import com.github.gungor.persistence.entity.Establishment;
import com.github.gungor.persistence.repository.EstablishmentRepository;
import com.github.gungor.service.EstablishmentService;
import com.github.gungor.service.FeatureService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    private EstablishmentRepository establishmentRepository;
    private FeatureService featureService;

    public EstablishmentServiceImpl(EstablishmentRepository establishmentRepository, FeatureService featureService) {
        this.establishmentRepository = establishmentRepository;
        this.featureService = featureService;
    }

    @Override
    public void saveEstablishment(EstablishmentCreateRequest request) {
        Establishment establishment = new Establishment();
        establishment.setName(request.getEstablishmentName());
        establishment.setFeatureIdSet( request.getFeatureIdList().stream().collect(Collectors.toSet()) );
        establishmentRepository.save(establishment);
    }

    @Override
    public EstablishmentResponse getEstablishment(Integer establishmentId) throws Exception {
        Establishment establishment = establishmentRepository.findById(establishmentId)
                .orElseThrow(() -> new Exception(String.format("Establishment not found by id : {}", establishmentId)));
        EstablishmentResponse response = new EstablishmentResponse();
        response.setEstablishmentName(establishment.getName());
        response.setFeatures(featureService.getFeatures().stream().filter(f-> establishment.getFeatureIdSet().contains(f.getId().toString())).collect(Collectors.toList()) );
        return response;
    }

}
