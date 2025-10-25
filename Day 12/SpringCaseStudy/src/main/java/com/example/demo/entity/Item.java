package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private TransportRequest transportRequest;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(precision = 10, scale = 2)
    private BigDecimal volume;


    @Column(nullable = false)
    private int quantity;

    // Constructors, getters, setters
}
