package com.aeki.ins.service;

import com.aeki.ins.model.Product;
import com.aeki.ins.rest.AvailableProducts;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ProductService {
    public void createProduct(Product product);
    public AvailableProducts getProductAvailability(String productName) throws NotImplementedException;
}
