package com.github.gungor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FeatureCreateRequest {

    @JsonProperty("name")
    private String name;
}
