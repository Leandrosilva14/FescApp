package com.leandro.fesc.api.v1.dto.product;

import java.util.List;

public class ProductListResponseDto {

    List<ProductCreateResponseDto> products;

    public List<ProductCreateResponseDto> getProducts() {
        return products;
    }

    public ProductListResponseDto setProducts(List<ProductCreateResponseDto> products) {
        this.products = products;
        return this;
    }
}
