package com.aeki.ins.utils;

import com.aeki.ins.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Configuration
public class ProductsDataLoader implements CommandLineRunner {
    private final String PRODUCTS_JSON = "/products.json";
    private final ProductService productService;

    @Autowired
    public ProductsDataLoader(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading products data");
        try {
            TypeReference<Product> typeReference = new TypeReference<Product>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(PRODUCTS_JSON);
            Product products = new ObjectMapper().readValue(inputStream, typeReference);
            products.getProducts().forEach(productData ->
                    productData.getContain_articles().stream().forEach
                            (containedArticles -> productService.createProduct(new com.aeki.ins.model.Product
                                    (UUID.randomUUID().toString(),
                                            productData.getName().trim(),
                                            containedArticles.getArt_id().trim(),
                                            containedArticles.getAmount_of()))));
            log.info("Loaded products data successfully");
            inputStream.close();
        } catch (Exception ex) {
            log.error("Exception while loading product data", ex);
        }
    }
}
