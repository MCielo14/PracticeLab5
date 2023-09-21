package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "locations", schema = "hr")
public class Location {
    @Id
    @Column(name = "location_id", nullable = false)
    private Integer id;

    @Column(name = "street_address", length = 40)
    private String streetAddress;

    @Column(name = "postal_code", length = 12)
    private String postalCode;

    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Column(name = "state_province", length = 25)
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


}