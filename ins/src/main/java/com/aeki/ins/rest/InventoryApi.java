package com.aeki.ins.rest;

import com.aeki.ins.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventory")
public class InventoryApi {
    private final ProductService productService;

    @Autowired
    public InventoryApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/items")
    public String allInventory(){
        return "Items";
    }

    @GetMapping
    public ResponseEntity<AvailableProducts> getAllProductsWithQuantity(@RequestParam String productName){
       return  ResponseEntity.ok(productService.getProductAvailability(productName));
    }

}
