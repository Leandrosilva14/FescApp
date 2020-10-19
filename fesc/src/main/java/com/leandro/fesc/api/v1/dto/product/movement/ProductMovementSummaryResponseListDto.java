package com.leandro.fesc.api.v1.dto.product.movement;

import java.util.List;

public class ProductMovementSummaryResponseListDto {

    private List<ProductMovementSummaryResponseDto> summaries;

    public List<ProductMovementSummaryResponseDto> getSummaries() {
        return summaries;
    }

    public ProductMovementSummaryResponseListDto setSummaries(List<ProductMovementSummaryResponseDto> summaries) {
        this.summaries = summaries;
        return this;
    }
}
