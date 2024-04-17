package com.github.gungor.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name="FEATURE")
@NoArgsConstructor
@AllArgsConstructor
public class Feature implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(generator = "SEQ_FEATURE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_FEATURE", sequenceName = "SEQ_FEATURE", allocationSize = 1)
    private Integer id;

    @Column(name="NAME")
    private String name;

}
