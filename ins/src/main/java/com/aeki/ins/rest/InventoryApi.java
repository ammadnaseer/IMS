package com.aeki.ins.rest;

import com.aeki.ins.exception.ProductNotfoundException;
import com.aeki.ins.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("inventory")
public class InventoryApi {
    private final ProductService productService;

    @Autowired
    public InventoryApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<AvailableProducts>> getAllProductsWithQuantity() {
        return ResponseEntity.ok(productService.getAllProductsWithQuantity());
    }

    @DeleteMapping("/product/{name}")
    public ResponseEntity<String> sellProduct(@PathVariable String name) {
        try {
            productService.removeProductByName(name);
            return ResponseEntity.ok("product named as " + name + " removed!");
        }catch(ProductNotfoundException productNotfoundException){
            log.error("error", productNotfoundException.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product named "+name+" doesnot exist", productNotfoundException);
        }

    }

}
