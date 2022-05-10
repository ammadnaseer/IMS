package com.aeki.ins.persistence.service;

import com.aeki.ins.persistence.entity.ProductEntity;
import com.aeki.ins.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDataServiceImpl implements ProductDataService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductDataServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    @Override
    public Optional<ProductEntity> getProductById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<List<ProductEntity>> getProductByName(String name) {
        return productRepository.findByProductName(name);
    }
}
