package com.leandro.fesc.api.v1.dto.product.movement;

import com.leandro.fesc.entity.movement.ProductMovementType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductMovementCreateDto {

    @NotNull
    @ApiModelProperty(value = "${product.movement.create.product.id}")
    private String productId;

    @NotNull
    @ApiModelProperty(value = "${product.movement.create.type}")
    private ProductMovementType type;

    @ApiModelProperty(value = "${product.movement.create.saleValue}")
    private BigDecimal saleValue;

    @NotNull
    @ApiModelProperty(value = "${product.movement.create.saleDate}")
    private LocalDateTime saleDate;

    @NotNull
    @ApiModelProperty(value = "${product.movement.create.quantity}")
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public ProductMovementCreateDto setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public ProductMovementType getType() {
        return type;
    }

    public ProductMovementCreateDto setType(ProductMovementType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductMovementCreateDto setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public ProductMovementCreateDto setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductMovementCreateDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
