package com.leandro.fesc.mapper;

import com.leandro.fesc.api.v1.dto.product.ProductUpdateDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementListResponseDto;
import com.leandro.fesc.configuration.CustomModelMapper;
import com.leandro.fesc.entity.movement.ProductMovement;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMovementMapper {

    private static final ModelMapper modelMapper = new CustomModelMapper();

    public static ProductMovement toEntity(ProductMovementCreateDto productMovementCreateDto) {
        return modelMapper.map(productMovementCreateDto, ProductMovement.class);
    }

    public static ProductMovementCreateResponseDto toResponseDto(ProductMovement productMovement) {
        return modelMapper.map(productMovement, ProductMovementCreateResponseDto.class)
                .setProduct(ProductMapper.toResponseDto(productMovement.getProduct()));
    }

    public static ProductMovementListResponseDto toProductMovementListResponseDto(List<ProductMovement> listProductProductMovements) {
        return new ProductMovementListResponseDto()
                .setProductMovements(listProductProductMovements.stream()
                        .map(ProductMovementMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }
}
