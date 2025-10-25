package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String licenseNumber;

    @Column(nullable = false, length = 50)
    private String contactNumber;

    @Column(nullable = false, length = 50)
    private String employmentStatus;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<VehicleAssignment> assignments;

    @OneToOne(mappedBy = "driver")
    private Vehicle vehicle;

    // Constructors, getters, setters
}
