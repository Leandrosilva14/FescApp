package com.leandro.fesc.service.product.movement;

import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementSummaryResponseListDto;
import com.leandro.fesc.configuration.Translator;
import com.leandro.fesc.entity.movement.ProductMovement;
import com.leandro.fesc.entity.movement.ProductMovementType;
import com.leandro.fesc.entity.product.Product;
import com.leandro.fesc.entity.product.ProductType;
import com.leandro.fesc.exceptions.BaseException;
import com.leandro.fesc.exceptions.NotFoundException;
import com.leandro.fesc.mapper.ProductMovementMapper;
import com.leandro.fesc.repository.ProductMovementRepository;
import com.leandro.fesc.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductMovementService {

    @Autowired
    private ProductMovementRepository productMovementRepository;

    @Autowired
    private ProductService productService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ProductMovementCreateResponseDto create(ProductMovementCreateDto productMovementCreateDto) throws BaseException {

        if(ProductMovementType.OUT.equals(productMovementCreateDto.getType())) {
            productService.checkHasAvailable(productMovementCreateDto.getProductId(), productMovementCreateDto.getQuantity().longValue());
        }

        Product product  = productService.findProductById(productMovementCreateDto.getProductId());
        ProductMovement productMovement = productMovementRepository.save(
                ProductMovementMapper.toEntity(productMovementCreateDto)
                        .setProduct(product));

        return ProductMovementMapper.toResponseDto(productMovement);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ProductMovement> list() {
        return productMovementRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ProductMovement findProductMovmentById(String id) throws BaseException {
        return productMovementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("product.movement.notfound.exception", new String[]{id})));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteProductMovement(String id) {
        productMovementRepository.delete(findProductMovmentById(id));
    }

    public ProductMovementSummaryResponseListDto listByProductType(ProductType productType) {
        return new ProductMovementSummaryResponseListDto().setSummaries(productMovementRepository.findByTypeAndProduct(productType, null));
    }

    public ProductMovementSummaryResponseListDto listByProduct(String productId) {
        return new ProductMovementSummaryResponseListDto().setSummaries(productMovementRepository.findByTypeAndProduct(null, productId));
    }
}
