package com.leandro.fesc.api.v1.dto.product.movement;

import java.util.List;

public class ProductMovementListResponseDto {

    List<ProductMovementCreateResponseDto> productMovements;

    public List<ProductMovementCreateResponseDto> getProductMovements() {
        return productMovements;
    }

    public ProductMovementListResponseDto setProductMovements(List<ProductMovementCreateResponseDto> productMovements) {
        this.productMovements = productMovements;
        return this;
    }
}
