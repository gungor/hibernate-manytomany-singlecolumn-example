package com.github.gungor.model;

import com.github.gungor.persistence.entity.Feature;
import lombok.Data;

import java.util.List;

@Data
public class EstablishmentResponse {


    private String establishmentName;

    private List<Feature> features;

}
