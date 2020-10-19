package com.leandro.fesc.api.v1.controller;

import com.leandro.fesc.api.ApiResponseMessages;
import com.leandro.fesc.api.RestPath;
import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductUpdateDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementSummaryResponseListDto;
import com.leandro.fesc.entity.product.ProductType;
import com.leandro.fesc.service.product.movement.ProductMovementService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductMovementController")
@RequestMapping(RestPath.BASE_PATH_V1 + "/product-movement")
@Api(tags = "ProductMovement")
public class ProductMovementController {

    @Autowired
    ProductMovementService productMovementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.movement.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201, response = ProductCreateResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ProductMovementCreateResponseDto create(
            @ApiParam(value = "${v1.product.movement}", required = true) @RequestBody @Valid ProductMovementCreateDto productMovementCreateDto) {
        return productMovementService.create(productMovementCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list-by-product-type", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.movement.list.by.product.type}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201, response = ProductMovementSummaryResponseListDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ProductMovementSummaryResponseListDto listByProductType(
            @RequestParam @Param("type") ProductType productType) {
        return productMovementService.listByProductType(productType);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list-by-product", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.movement.list.by.product}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201, response = ProductMovementSummaryResponseListDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ProductMovementSummaryResponseListDto listByProduct(@RequestParam @Param("product-id") String productId) {
        return productMovementService.listByProduct(productId);
    }

}
