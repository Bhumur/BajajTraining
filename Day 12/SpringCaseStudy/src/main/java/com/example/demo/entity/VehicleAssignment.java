package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_assignment")
public class VehicleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private TransportRequest transportRequest;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Column(nullable = false)
    private LocalDateTime assignmentDate;

    @Column(nullable = false)
    private LocalDateTime plannedStartDate;

    private LocalDateTime plannedEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;

    @Column(nullable = false, length = 50)
    private String assignmentStatus;

    // Constructors, getters, setters
}
