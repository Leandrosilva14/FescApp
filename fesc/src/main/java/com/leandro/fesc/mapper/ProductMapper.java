package com.leandro.fesc.mapper;

import com.leandro.fesc.api.v1.dto.product.ProductCreateDto;
import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductListResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductUpdateDto;
import com.leandro.fesc.configuration.CustomModelMapper;
import com.leandro.fesc.entity.product.Product;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    private static final ModelMapper modelMapper = new CustomModelMapper();

    public static Product toEntity(ProductCreateDto productCreateDto) {
        return modelMapper.map(productCreateDto, Product.class);
    }

    public static Product toEntity(ProductUpdateDto productUpdateDto) {
        return modelMapper.map(productUpdateDto, Product.class);
    }

    public static ProductCreateResponseDto toResponseDto(Product product) {
        return modelMapper.map(product, ProductCreateResponseDto.class)
                ;
    }

    public static ProductListResponseDto toProductListResponseDto(List<Product> listProduct) {
        return new ProductListResponseDto()
                .setProducts(listProduct.stream()
                        .map(ProductMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }
}
