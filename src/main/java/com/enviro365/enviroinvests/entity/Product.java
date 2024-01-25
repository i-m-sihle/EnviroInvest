package com.enviro365.enviroinvests.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    // Additional fields...
    private String description;
    private String type;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    // Constructors
    public Product() {
    }

    public Product(String name, double price, String description, Investor investor) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.investor = investor;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // toString, equals, and hashCode methods can be added as needed.

    // You can also add other methods as per your requirements.
}
