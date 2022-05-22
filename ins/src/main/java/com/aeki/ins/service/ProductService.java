package com.aeki.ins.service;

import com.aeki.ins.model.Product;
import com.aeki.ins.rest.AvailableProducts;

import java.util.List;

public interface ProductService {
     void createProduct(Product product);
     List<AvailableProducts> getAllProductsWithQuantity();
     void removeProductByName(String productName);
}
