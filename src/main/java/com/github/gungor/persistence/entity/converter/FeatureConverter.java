package com.github.gungor.persistence.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class FeatureConverter implements AttributeConverter<Set<String>, String> {

    private static final String SEPARATOR = ",";


    @Override
    public String convertToDatabaseColumn(Set<String> featureIds) {
        return featureIds.stream().collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public Set<String> convertToEntityAttribute(String featureIds) {
        return Stream.of(featureIds.split(SEPARATOR)).collect(Collectors.toSet());
    }
}