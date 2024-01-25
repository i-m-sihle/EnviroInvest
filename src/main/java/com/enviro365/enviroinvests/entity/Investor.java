package com.enviro365.enviroinvests.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents an Investor entity.
 */
@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contact;
    private int age;

    // Constructors (if needed)

    /**
     * Gets the ID of the investor.
     *
     * @return The investor's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the investor.
     *
     * @param id The investor's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the investor.
     *
     * @return The investor's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the investor.
     *
     * @param name The investor's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the investor.
     *
     * @return The investor's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the investor.
     *
     * @param address The investor's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the contact information of the investor.
     *
     * @return The investor's contact information.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact information of the investor.
     *
     * @param contact The investor's contact information.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the age of the investor.
     *
     * @return The investor's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the investor.
     *
     * @param age The investor's age.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
