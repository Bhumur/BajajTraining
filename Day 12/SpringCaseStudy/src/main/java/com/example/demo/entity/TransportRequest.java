package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transport_request")
public class TransportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    @Column(nullable = false, length = 255)
    private String pickupLocation;

    @Column(nullable = false, length = 255)
    private String deliveryLocation;

    @Column(nullable = false)
    private LocalDateTime requiredDeliveryDate;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @OneToMany(mappedBy = "transportRequest", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(mappedBy = "transportRequest", cascade = CascadeType.ALL)
    private List<VehicleAssignment> assignments;

    // Constructors, getters, setters
}
