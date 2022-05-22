package com.aeki.ins.persistence.service;

import com.aeki.ins.model.Article;
import com.aeki.ins.persistence.entity.InventoryEntity;
import com.aeki.ins.persistence.repository.InventoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Log4j2
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
    public BigInteger getArticleQuantity(String articleId) {
        BigInteger stock =  inventoryRepository.getArticleStock(articleId);
        return inventoryRepository.getArticleStock(articleId);
    }


}
