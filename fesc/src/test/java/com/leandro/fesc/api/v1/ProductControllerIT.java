package com.leandro.fesc.api.v1;

import static io.restassured.RestAssured.given;

import java.math.BigDecimal;

import com.leandro.fesc.AbstractTestController;
import com.leandro.fesc.api.v1.dto.product.ProductCreateDto;
import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.entity.product.ProductType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() {
        ProductCreateDto productCreateDto = createProductDto();

        ProductCreateResponseDto productCreateResponseDto = createAndReturnResponseDto(productCreateDto);

        assertCreatedProduct(productCreateDto, productCreateResponseDto);
    }

    private void assertCreatedProduct(ProductCreateDto productCreateDto, ProductCreateResponseDto productCreateResponseDto) {
        Assert.assertNotNull(productCreateResponseDto.getId());

        Assert.assertEquals(productCreateDto.getCode(), productCreateResponseDto.getCode());
        Assert.assertEquals(productCreateDto.getDescription(), productCreateResponseDto.getDescription());
        Assert.assertEquals(String.valueOf(productCreateDto.getProductType()), productCreateResponseDto.getProductType());
        Assert.assertEquals(productCreateDto.getProviderValue(), productCreateResponseDto.getProviderValue());
        Assert.assertEquals(productCreateDto.getQuantity(), productCreateResponseDto.getQuantity());
    }

    private ProductCreateDto createProductDto() {
        return new ProductCreateDto()
                .setCode(1l)
                .setDescription("Produto1")
                .setProductType(ProductType.ELETRONIC)
                .setProviderValue(new BigDecimal(100.0))
                .setQuantity(2);
    }

    private ProductCreateResponseDto createAndReturnResponseDto(ProductCreateDto productCreateDto) {
        return given()
                .header("Content-Type", "application/json")
                .body(productCreateDto)
                .post(PRODUCT_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(ProductCreateResponseDto.class);
    }
}
