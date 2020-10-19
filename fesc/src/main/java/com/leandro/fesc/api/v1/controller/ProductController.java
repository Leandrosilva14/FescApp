package com.leandro.fesc.api.v1.controller;

import com.leandro.fesc.mapper.ProductMapper;
import com.leandro.fesc.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.fesc.api.ApiResponseMessages;
import com.leandro.fesc.api.RestPath;
import com.leandro.fesc.api.v1.dto.product.ProductCreateDto;
import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductListResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductUpdateDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController("ProductController")
@RequestMapping(RestPath.BASE_PATH_V1 + "/product")
@Api(tags = "Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201, response = ProductCreateResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ProductCreateResponseDto create(
            @ApiParam(value = "${v1.product}", required = true) @RequestBody @Valid ProductCreateDto productCreateDto) {
        return productService.create(productCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201, response = ProductListResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ProductListResponseDto list() {
        return ProductMapper.toProductListResponseDto(productService.list());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    @ApiOperation(value = "${v1.product.delete}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)
    })
    public void delete(
            @ApiParam(value = "${v1.product.id}", required = true) @RequestParam @Param("id") String id) {
        productService.deleteProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.update}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public void update(
            @ApiParam(value = "${v1.product}", required = true)  @RequestBody @Valid ProductUpdateDto productUpdateDto) {
        productService.update(productUpdateDto);
    }


}
