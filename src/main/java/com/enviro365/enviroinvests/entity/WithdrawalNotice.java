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

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    // Constructors

    /**
     * Default constructor for WithdrawalNotice.
     */
    public WithdrawalNotice() {
    }

    /**
     * Parameterized constructor for WithdrawalNotice.
     *
     * @param withdrawalAmount The amount withdrawn.
     * @param withdrawalDate   The date of withdrawal.
     * @param product          The associated product.
     * @param investor         The associated investor.
     */
    public WithdrawalNotice(BigDecimal withdrawalAmount, LocalDateTime withdrawalDate, Product product, Investor investor) {
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.product = product;
        this.investor = investor;
    }

    // Getters and Setters

    /**
     * Gets the ID of the withdrawal notice.
     *
     * @return The withdrawal notice ID.
     */
    public Long getWithdrawalId() {
        return withdrawalId;
    }

    /**
     * Sets the ID of the withdrawal notice.
     *
     * @param withdrawalId The withdrawal notice ID.
     */
    public void setWithdrawalId(Long withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    /**
     * Gets the withdrawal amount.
     *
     * @return The withdrawal amount.
     */
    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    /**
     * Sets the withdrawal amount.
     *
     * @param withdrawalAmount The withdrawal amount.
     */
    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    /**
     * Gets the date of withdrawal.
     *
     * @return The date of withdrawal.
     */
    public LocalDateTime getWithdrawalDate() {
        return withdrawalDate;
    }

    /**
     * Sets the date of withdrawal.
     *
     * @param withdrawalDate The date of withdrawal.
     */
    public void setWithdrawalDate(LocalDateTime withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    /**
     * Gets the associated product.
     *
     * @return The associated product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the associated product.
     *
     * @param product The associated product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the associated investor.
     *
     * @return The associated investor.
     */
    public Investor getInvestor() {
        return investor;
    }

    /**
     * Sets the associated investor.
     *
     * @param investor The associated investor.
     */
    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
