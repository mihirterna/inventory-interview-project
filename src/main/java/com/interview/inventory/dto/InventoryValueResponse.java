package com.interview.inventory.dto;

import java.math.BigDecimal;
import java.util.List; // <-- Import List

public class InventoryValueResponse {

    private BigDecimal grossValue;
    private BigDecimal totalDiscountAmount;
    private BigDecimal netValue;
    private String discountDetails;
    private List<ProductValuationDto> productBreakdown; // <-- ADD THIS LINE

    // Constructors can be removed for simplicity if you set fields directly

    // Getters and Setters
    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public BigDecimal getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(BigDecimal totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public String getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    // ADD GETTER AND SETTER FOR THE NEW LIST
    public List<ProductValuationDto> getProductBreakdown() {
        return productBreakdown;
    }

    public void setProductBreakdown(List<ProductValuationDto> productBreakdown) {
        this.productBreakdown = productBreakdown;
    }
}