package com.aeki.ins.rest;

import com.aeki.ins.exception.ProductNotfoundException;
import com.aeki.ins.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
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


    @Operation(summary = "Gets the list of product with name and remaining quantity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieves a list of available products",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AvailableProducts.class))})
    })
    @GetMapping("products")
    public ResponseEntity<List<AvailableProducts>> getAllProductsWithQuantity() {
        return ResponseEntity.ok(productService.getAllProductsWithQuantity());
    }

    @Operation(summary = "Deletes a product by its name, can be used for sell functionality")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The product was removed",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = "Product that you are trying to delete could not be found",
                    content = @Content)})
    @DeleteMapping("/product/{name}")
    public ResponseEntity<String> sellProduct(@Parameter(description = "name of the product")
                                              @PathVariable String name) {
        try {
            productService.removeProductByName(name);
            return ResponseEntity.ok("product named as " + name + " removed!");
        } catch (ProductNotfoundException productNotfoundException) {
            log.error("error", productNotfoundException.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product named " + name + " doesnot exist", productNotfoundException);
        }

    }

}
