package com.enviro365.enviroinvests.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Represents a Product entity.
 */
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
    /**
     * Gets the type of the product.
     *
     * @return The product's type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the product.
     *
     * @param type The product's type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the balance of the product.
     *
     * @return The product's balance.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the product.
     *
     * @param balance The product's balance.
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Gets the ID of the product.
     *
     * @return The product's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The product's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The product's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The product's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The product's price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the description of the product.
     *
     * @return The product's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description The product's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the investor associated with the product.
     *
     * @return The investor associated with the product.
     */
    public Investor getInvestor() {
        return investor;
    }

    /**
     * Sets the investor associated with the product.
     *
     * @param investor The investor associated with the product.
     */
    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    // toString, equals, and hashCode methods can be added as needed.

    // You can also add other methods as per your requirements.
}
