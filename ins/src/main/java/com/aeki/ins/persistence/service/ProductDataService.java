package com.aeki.ins.persistence.service;

import com.aeki.ins.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductDataService {
    void saveProduct(ProductEntity productEntity);
    Optional<ProductEntity> getProductById(String productId);
    Optional<List<ProductEntity>> getProductByName(String name);
    Set<String> allProductNames();

}
