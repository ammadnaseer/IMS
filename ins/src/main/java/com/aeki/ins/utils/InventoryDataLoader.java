package com.aeki.ins.utils;

import com.aeki.ins.model.Article;
import com.aeki.ins.service.InventoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Slf4j
@Configuration
public class InventoryDataLoader implements CommandLineRunner {
    private final String INVENTORY_JSON = "/inventory.json";
    private final InventoryService inventoryService;

    @Autowired
    public InventoryDataLoader(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Loading inventory data!");
        try {
            TypeReference<Inventory> typeReference = new TypeReference<Inventory>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(INVENTORY_JSON);
            Inventory inventoryList = new ObjectMapper().readValue(inputStream, typeReference);
            inventoryList.inventory.stream().forEach(i ->
                    inventoryService.addArticleToInventory(new Article(i.art_id, i.getName()), i.stock));
            inputStream.close();
        } catch (Exception ex) {
            log.error("Exception while loading inventory data", ex);
        }
    }
}
