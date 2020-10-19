package com.leandro.fesc.repository;

import com.leandro.fesc.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT SUM(CASE WHEN (m.type = com.leandro.fesc.entity.movement.ProductMovementType.IN) THEN m.quantity ELSE -m.quantity END) \n" +
            "FROM Product p \n" +
            "LEFT JOIN p.movements m \n" +
            "WHERE p.id = :productId")
    long countById(String productId);

    List<Product> findByCode(Long code);
}
