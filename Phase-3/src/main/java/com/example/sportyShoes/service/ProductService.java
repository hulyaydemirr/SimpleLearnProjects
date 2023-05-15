package com.example.sportyShoes.service;

import com.example.sportyShoes.model.Product;
import com.example.sportyShoes.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean insertProduct(Product product) {
        try {
            log.info("[insertProduct] started! product will be inserted! :: product ={}", product);
            if (!isProductAlreadyExist(product)) {
                productRepository.save(product);
                log.info("[insertProduct] new product inserted! :: product ={}", product);
                return true;
            }
        } catch (Exception e) {
            log.error("[insertProduct] Exception occurred! Product could not be added!");
        }
        return false;
    }

    private boolean isProductAlreadyExist(Product product) {
        try {
            return productRepository.existsByCategoryIdAndProductName(product.getCategoryId(),
                                                                                product.getProductName());
        } catch (DataAccessException dataAccessException) {
            log.error("[isProductAlreadyExist] Exception occurred while getting data from db!", dataAccessException);
        } catch (Exception e) {
            log.error("[isProductAlreadyExist] Exception occurred!", e);
        }
        return true;
    }
}
