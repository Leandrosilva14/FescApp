package com.leandro.fesc.repository;

import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementSummaryResponseDto;
import com.leandro.fesc.entity.movement.ProductMovement;
import com.leandro.fesc.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, String> {

    @Query(value = "SELECT new com.leandro.fesc.api.v1.dto.product.movement.ProductMovementSummaryResponseDto(\n" +
                "p.id, \n" +
                "p.code, \n" +
                "p.description, \n" +
                "SUM(CASE WHEN (m.type = com.leandro.fesc.entity.movement.ProductMovementType.OUT) THEN m.quantity ELSE 0 END), \n" +
                "(SUM(CASE WHEN m.type = com.leandro.fesc.entity.movement.ProductMovementType.IN THEN m.quantity  ELSE (-m.quantity) END)), \n" +
                "SUM(COALESCE(m.saleValue,0) * COALESCE(m.quantity, 0)) - SUM(p.providerValue * COALESCE(CASE WHEN m.type = com.leandro.fesc.entity.movement.ProductMovementType.OUT THEN m.quantity ELSE 0 END,0))\n" +
                "\n) " +
            "FROM Product p \n" +
            "LEFT JOIN p.movements m " +
            "WHERE (p.productType = :productType OR :productType IS NULL) \n" +
            "AND (p.id = :productId OR :productId IS NULL) \n" +
            "GROUP BY p.id, p.code, p.description \n" +
            "ORDER BY p.id\n")
    List<ProductMovementSummaryResponseDto> findByTypeAndProduct(ProductType productType, String productId);
}
