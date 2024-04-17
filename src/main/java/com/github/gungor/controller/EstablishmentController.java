package com.github.gungor.controller;

import com.github.gungor.model.EstablishmentCreateRequest;
import com.github.gungor.model.EstablishmentResponse;
import com.github.gungor.model.FeatureCreateRequest;
import com.github.gungor.service.EstablishmentService;
import com.github.gungor.service.FeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstablishmentController {

    private EstablishmentService establishmentService;
    private FeatureService featureService;

    public EstablishmentController(EstablishmentService establishmentService, FeatureService featureService) {
        this.establishmentService = establishmentService;
        this.featureService = featureService;
    }

    @PostMapping("/establishment")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEstablishment(@RequestBody EstablishmentCreateRequest request){
        establishmentService.saveEstablishment(request);
    }

    @PostMapping("/feature")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addFeature(@RequestBody FeatureCreateRequest request){
        featureService.saveFeature(request);
    }

    @GetMapping("/establishment/{id}")
    public EstablishmentResponse getEstablishment(@PathVariable Integer id) throws Exception {
        return establishmentService.getEstablishment(id);
    }
}
