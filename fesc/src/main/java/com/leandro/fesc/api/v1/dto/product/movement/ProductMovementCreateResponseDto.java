package com.leandro.fesc.api.v1.dto.product.movement;

import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.entity.movement.ProductMovementType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductMovementCreateResponseDto {

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${product.movement.create.id}")
    private String id;

    @NotNull
    @ApiModelProperty(value = "${product.movement.create.product}")
    private ProductCreateResponseDto product;

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

    public String getId() {
        return id;
    }

    public ProductMovementCreateResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public ProductCreateResponseDto getProduct() {
        return product;
    }

    public ProductMovementCreateResponseDto setProduct(ProductCreateResponseDto product) {
        this.product = product;
        return this;
    }

    public ProductMovementType getType() {
        return type;
    }

    public ProductMovementCreateResponseDto setType(ProductMovementType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductMovementCreateResponseDto setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public ProductMovementCreateResponseDto setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductMovementCreateResponseDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
