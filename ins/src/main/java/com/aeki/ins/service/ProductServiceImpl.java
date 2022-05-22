package com.aeki.ins.service;

import com.aeki.ins.exception.ProductNotfoundException;
import com.aeki.ins.model.Product;
import com.aeki.ins.persistence.entity.ProductEntity;
import com.aeki.ins.persistence.service.InventoryDataService;
import com.aeki.ins.persistence.service.ProductDataService;
import com.aeki.ins.rest.AvailableProducts;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
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
    public List<AvailableProducts> getAllProductsWithQuantity() {
        return productDataService.allProductNames().stream().map(this::countProductQuantity).collect(Collectors.toList());
    }

    @Override
    public void removeProductByName(String productName) {
        if (countProductQuantity(productName).getQuantityAvailable().compareTo(BigInteger.ZERO) > 0 ){
            removeProduct(productName);
        } else {
            log.error("Trying to sell a product that does not exist");
            throw new ProductNotfoundException("Product "+productName+" does not exist in the inventory");
        }

    }

    private AvailableProducts countProductQuantity(String productName) {
        List<ProductEntity> products = productDataService.getProductByName(productName).get();
        List<BigInteger> quantities = products.stream().map
                (productRecord -> inventoryDataService.getArticleQuantity(productRecord.getArticleId()).divide(productRecord.getArticleQuantity()))
                .collect(Collectors.toList());
        if (quantities.size() == 0){
            throw new ProductNotfoundException("Product with name "+productName+" does not exist");
        }
        return new AvailableProducts(productName, Collections.min(quantities));
    }

    private void removeProduct(String productName){
        List<ProductEntity> products = productDataService.getProductByName(productName).get();
        products.forEach(productEntity ->
                inventoryDataService.updateArticleQuantity(productEntity.getArticleId(),
                        inventoryDataService.getArticleQuantity(productEntity.getArticleId()).subtract(productEntity.getArticleQuantity()))) ;

    }


}
