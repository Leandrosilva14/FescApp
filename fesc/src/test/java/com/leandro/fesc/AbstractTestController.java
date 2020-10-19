package com.leandro.fesc;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.leandro.fesc.api.RestPath;
import com.leandro.fesc.repository.ProductRepository;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class AbstractTestController {

    public static String API_V1;
    public static String PRODUCT_RESOURCE;

    @LocalServerPort
    public int randomPort;

    @Autowired
    private ProductRepository productRepository;


    public void setup() throws Exception {
        RestAssured.port = randomPort;
        API_V1 = RestPath.BASE_PATH_V1;
        PRODUCT_RESOURCE = API_V1 + "/product";
    }

    public void delete() {
        productRepository.deleteAll();
    }
}
