package com.example.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    @Column(nullable = false)
    private String type;

    @Column(precision = 10, scale = 2)
    private BigDecimal capacity;


    @Column(nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(nullable = false)
    private String maker;

    @Column(nullable = false)
    private String model;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleAssignment> assignments;

    // Constructors, getters, setters
}
