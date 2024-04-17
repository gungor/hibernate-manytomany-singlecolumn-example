package com.github.gungor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentCreateRequest {

    @JsonProperty("establishmentName")
    private String establishmentName;

    @JsonProperty("featureIdList")
    private List<String> featureIdList;

}
