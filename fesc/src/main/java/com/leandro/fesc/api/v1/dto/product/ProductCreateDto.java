package com.leandro.fesc.api.v1.dto.product;

import com.leandro.fesc.entity.product.ProductType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductCreateDto {

    @NotNull
    @ApiModelProperty(value = "${product.create.code}")
    private Long code;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${product.create.description}")
    private String description;

    @NotNull
    @ApiModelProperty(value = "${product.create.productType}")
    private ProductType productType;

    @NotNull
    @ApiModelProperty(value = "${product.create.providerValue}")
    private BigDecimal providerValue;

    @NotNull
    @ApiModelProperty(value = "${product.create.quantity}")
    private Integer quantity;

    public Long getCode() {
        return code;
    }

    public ProductCreateDto setCode(Long code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductCreateDto setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public BigDecimal getProviderValue() {
        return providerValue;
    }

    public ProductCreateDto setProviderValue(BigDecimal providerValue) {
        this.providerValue = providerValue;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductCreateDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
