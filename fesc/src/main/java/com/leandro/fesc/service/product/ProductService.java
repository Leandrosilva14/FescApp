package com.leandro.fesc.service.product;

import com.leandro.fesc.api.v1.dto.product.movement.ProductMovementCreateDto;
import com.leandro.fesc.entity.movement.ProductMovement;
import com.leandro.fesc.entity.movement.ProductMovementType;
import com.leandro.fesc.exceptions.ProductCodeAlreadyExistException;
import com.leandro.fesc.exceptions.ProductQuantityNotAvailableException;
import com.leandro.fesc.mapper.ProductMapper;
import com.leandro.fesc.api.v1.dto.product.ProductCreateDto;
import com.leandro.fesc.api.v1.dto.product.ProductCreateResponseDto;
import com.leandro.fesc.api.v1.dto.product.ProductUpdateDto;
import com.leandro.fesc.configuration.Translator;
import com.leandro.fesc.entity.product.Product;
import com.leandro.fesc.exceptions.BaseException;
import com.leandro.fesc.exceptions.NotFoundException;
import com.leandro.fesc.repository.ProductMovementRepository;
import com.leandro.fesc.repository.ProductRepository;
import com.leandro.fesc.service.product.movement.ProductMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMovementService productMovementService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ProductCreateResponseDto create(ProductCreateDto productCreateDTO) throws BaseException {

        validateProductCode(productCreateDTO.getCode());
        Product product = productRepository.save(ProductMapper.toEntity(productCreateDTO));

        ProductMovementCreateDto productMovementCreateDto = new ProductMovementCreateDto()
                .setProductId(product.getId())
                .setQuantity(product.getQuantity())
                .setSaleDate(LocalDateTime.now())
                .setSaleValue(BigDecimal.ZERO)
                .setType(ProductMovementType.IN);
        productMovementService.create(productMovementCreateDto);

        return ProductMapper.toResponseDto(product);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Product findProductById(String id) throws BaseException {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("product.notfound.exception", new String[]{id})));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteProduct(String id) {
        productRepository.delete(findProductById(id));
    }

    public void update(ProductUpdateDto productUpdateDto) {
        findProductById(productUpdateDto.getId());
        productRepository.save(ProductMapper.toEntity(productUpdateDto));

    }

    public void checkHasAvailable(String productId, Long quantity) {
        Long quantityAvailable = productRepository.countById(productId);
        if(quantityAvailable < quantity) {
            throw new ProductQuantityNotAvailableException();
        }
    }

    private void validateProductCode(Long productCode) {
        if(productRepository.findByCode(productCode).size() > 0) {
            throw new ProductCodeAlreadyExistException();
        }
    }
}
