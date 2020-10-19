package com.leandro.fesc.entity.product;

import com.leandro.fesc.entity.movement.ProductMovement;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "CODE", nullable = false)
    private Long code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRODUCT_TYPE")
    private ProductType productType;

    @Column(name = "PROVIDER_VALUE", nullable = false)
    private BigDecimal providerValue;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductMovement> movements;

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public Long getCode() {
        return code;
    }

    public Product setCode(Long code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Product setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public BigDecimal getProviderValue() {
        return providerValue;
    }

    public Product setProviderValue(BigDecimal providerValue) {
        this.providerValue = providerValue;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<ProductMovement> getMovements() {
        return movements;
    }

    public Product setMovements(List<ProductMovement> movements) {
        this.movements = movements;
        return this;
    }
}
