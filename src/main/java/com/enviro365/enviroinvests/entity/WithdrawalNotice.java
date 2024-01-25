package com.enviro365.enviroinvests.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a withdrawal notice entity with details like withdrawal amount and date.
 */
@Entity
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;

    private BigDecimal withdrawalAmount;

    private LocalDateTime withdrawalDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors, getters, and setters
}