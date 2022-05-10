package com.aeki.ins.service;

import com.aeki.ins.model.Article;
import com.aeki.ins.persistence.service.InventoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryDataService inventoryDataService;

    @Autowired
    public InventoryServiceImpl(InventoryDataService inventoryDataService) {
        this.inventoryDataService = inventoryDataService;
    }

    @Override
    public void addArticleToInventory(Article article, BigInteger stock) {
        inventoryDataService.addArticleToInventory(UUID.randomUUID().toString(), article, stock);
    }
}
