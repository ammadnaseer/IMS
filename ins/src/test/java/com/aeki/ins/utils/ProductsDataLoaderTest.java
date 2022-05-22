package com.aeki.ins.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;


public class ProductsDataLoaderTest {
    private static final String PRODUCTS_DATA = "/products.json";


    @Test
    void testThatProductNamesAreUnique()  {
        List<String> productNames = getAllProductNames();
        Set<String> productNamesUnique = new HashSet<>(productNames);
        Assertions.assertEquals(productNames.size(), productNamesUnique.size(),"The product names cannot be repeated");
    }


    private List<String> getAllProductNames() {
        try {
            TypeReference<Product> typeReference = new TypeReference<Product>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(PRODUCTS_DATA);
            Product products = new ObjectMapper().readValue(inputStream, typeReference);
            List<String> productNames = products.getProducts().stream().map(singleProduct -> singleProduct.name).collect(Collectors.toList());
            inputStream.close();
            return productNames;
        } catch (DatabindException ex) {
            fail("Product data file with incorrect object or json format");
            return null;
        } catch (Exception ex) {
            fail("Exception while reading product data");
            return null;
        }
    }


}
