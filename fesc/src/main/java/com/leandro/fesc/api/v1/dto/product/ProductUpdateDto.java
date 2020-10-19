package com.leandro.fesc.api.v1.dto.product;

import com.leandro.fesc.entity.product.ProductType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductUpdateDto {

    @ApiModelProperty(value = "${product.create.id}")
    private String id;

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

    public String getId() {
        return id;
    }

    public ProductUpdateDto setId(String id) {
        this.id = id;
        return this;
    }

    public Long getCode() {
        return code;
    }

    public ProductUpdateDto setCode(Long code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductUpdateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductUpdateDto setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public BigDecimal getProviderValue() {
        return providerValue;
    }

    public ProductUpdateDto setProviderValue(BigDecimal providerValue) {
        this.providerValue = providerValue;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductUpdateDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
