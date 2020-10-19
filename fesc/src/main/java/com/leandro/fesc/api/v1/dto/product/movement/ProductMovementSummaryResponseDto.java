package com.leandro.fesc.api.v1.dto.product.movement;

import java.math.BigDecimal;

public class ProductMovementSummaryResponseDto {

    private String productId;
    private Long productCode;
    private String productDescription;
    private Long quantityOut;
    private Long quantityAvailable;
    private BigDecimal profitValue;

    public ProductMovementSummaryResponseDto(String productId, Long productCode, String productDescription, Long quantityOut, Long quantityAvailable, BigDecimal profitValue) {
        this.productId = productId;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.quantityOut = quantityOut;
        this.quantityAvailable = quantityAvailable;
        this.profitValue = profitValue;
    }

    public String getProductId() {
        return productId;
    }

    public ProductMovementSummaryResponseDto setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public Long getProductCode() {
        return productCode;
    }

    public ProductMovementSummaryResponseDto setProductCode(Long productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public ProductMovementSummaryResponseDto setProductDescription(String productDescription) {
        this.productDescription = productDescription;
        return this;
    }

    public Long getQuantityOut() {
        return quantityOut;
    }

    public ProductMovementSummaryResponseDto setQuantityOut(Long quantityOut) {
        this.quantityOut = quantityOut;
        return this;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public ProductMovementSummaryResponseDto setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
        return this;
    }

    public BigDecimal getProfitValue() {
        return profitValue;
    }

    public ProductMovementSummaryResponseDto setProfitValue(BigDecimal profitValue) {
        this.profitValue = profitValue;
        return this;
    }
}
