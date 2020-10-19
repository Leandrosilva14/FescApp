package com.leandro.fesc.entity.movement;

import com.leandro.fesc.entity.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCT_MOVEMENT")
public class ProductMovement {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;

    @Column(name = "TYPE", nullable = false)
    private ProductMovementType type;

    @Column(name = "SALE_VALUE")
    private BigDecimal saleValue;

    @Column(name = "SALE_DATE", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    public String getId() {
        return id;
    }

    public ProductMovement setId(String id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public ProductMovement setProduct(Product product) {
        this.product = product;
        return this;
    }

    public ProductMovementType getType() {
        return type;
    }

    public ProductMovement setType(ProductMovementType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductMovement setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public ProductMovement setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductMovement setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
