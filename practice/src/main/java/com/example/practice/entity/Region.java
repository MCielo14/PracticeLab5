package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "regions", schema = "hr")
public class Region {
    @Id
    @Column(name = "region_id", nullable = false, precision = 22)
    private BigDecimal id;

    @Column(name = "region_name", length = 25)
    private String regionName;

}