package com.aeki.ins.persistence.service;

import com.aeki.ins.model.Article;
import com.aeki.ins.persistence.entity.InventoryEntity;
import com.aeki.ins.persistence.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class InventoryDataServiceImpl implements InventoryDataService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryDataServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void addArticleToInventory(String id, Article article, BigInteger quantity) {
        inventoryRepository.save(InventoryEntity.builder().id(id).
                articleId(article.getArticleId()).
                articleName(article.getName()).
                stock(quantity).build());
    }

    @Override
    public void updateArticleQuantity(String id, BigInteger quantity) {
        inventoryRepository.update(id, quantity);
    }

    @Override
    public boolean getArticleQuantity(String articleId) {


        return false;
    }


}
