package com.github.gungor.service;

import com.github.gungor.model.EstablishmentCreateRequest;
import com.github.gungor.model.EstablishmentResponse;

public interface EstablishmentService {

    void saveEstablishment(EstablishmentCreateRequest request);

    EstablishmentResponse getEstablishment(Integer establishmentId) throws Exception;

}
