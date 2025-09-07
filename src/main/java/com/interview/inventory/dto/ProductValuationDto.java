package com.interview.inventory.dto;

import java.math.BigDecimal;

public class ProductValuationDto {

    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineGrossValue;
    private BigDecimal discountApplied;
    private BigDecimal lineNetValue;

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineGrossValue() {
        return lineGrossValue;
    }

    public void setLineGrossValue(BigDecimal lineGrossValue) {
        this.lineGrossValue = lineGrossValue;
    }

    public BigDecimal getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(BigDecimal discountApplied) {
        this.discountApplied = discountApplied;
    }

    public BigDecimal getLineNetValue() {
        return lineNetValue;
    }

    public void setLineNetValue(BigDecimal lineNetValue) {
        this.lineNetValue = lineNetValue;
    }
}