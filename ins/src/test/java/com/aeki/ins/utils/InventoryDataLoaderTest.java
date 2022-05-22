package com.aeki.ins.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryDataLoaderTest {
    private final String INVENTORY_JSON = "/inventory.json";


    @Test
    void testThatArticleIdsAreUnique()  {
        List<String> articleIds = getAllArticleIds();
        Set<String> articleIdsUnique = new HashSet<>(articleIds);
        Assertions.assertEquals(articleIds.size(), articleIdsUnique.size(),"The article ids have to be unique");
    }



    private List<String> getAllArticleIds(){
        try {
            TypeReference<Inventory> typeReference = new TypeReference<Inventory>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(INVENTORY_JSON);
            Inventory inventoryList = new ObjectMapper().readValue(inputStream, typeReference);
            List<String> articleIds = inventoryList.inventory.stream().map(i -> i.getArt_id()).collect(Collectors.toList());
            inputStream.close();
            return articleIds;
        } catch (Exception ex) {
        }
        return null;
    }
}
