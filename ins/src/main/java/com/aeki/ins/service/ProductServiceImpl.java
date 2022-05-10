package com.aeki.ins.service;

import com.aeki.ins.model.Product;
import com.aeki.ins.persistence.entity.ProductEntity;
import com.aeki.ins.persistence.service.InventoryDataService;
import com.aeki.ins.persistence.service.ProductDataService;
import com.aeki.ins.rest.AvailableProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class ProductServiceImpl implements ProductService {
    private final ProductDataService productDataService;
    private final InventoryDataService inventoryDataService;

    @Autowired
    public ProductServiceImpl(ProductDataService productDataService, InventoryDataService inventoryDataService) {
        this.productDataService = productDataService;
        this.inventoryDataService = inventoryDataService;
    }

    @Override
    public void createProduct(Product product) {
        productDataService.saveProduct(new ProductEntity(product.getId(), product.getName(), product.getArticleId(), product.getQuantity()));
    }

    @Override
    public AvailableProducts getProductAvailability(String productName) throws NotImplementedException {
        throw new NotImplementedException();
    }

}
