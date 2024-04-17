package com.github.gungor.persistence.entity;


import com.github.gungor.persistence.entity.converter.FeatureConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name="ESTABLISHMENT")
@NoArgsConstructor
public class Establishment {

    @Id
    @Column(name="ID")
    @GeneratedValue(generator = "SEQ_ESTABLISHMENT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_ESTABLISHMENT", sequenceName = "SEQ_ESTABLISHMENT", allocationSize = 1)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="FEATURE_IDS")
    @Convert(converter = FeatureConverter.class)
    private Set<String> featureIdSet;

}
