package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "countries", schema = "hr")
public class Country {
    @Id
    @Column(name = "country_id", nullable = false, length = 2)
    private String countryId;

    @Column(name = "country_name", length = 40)
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}