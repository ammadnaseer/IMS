package com.aeki.ins.persistence.service;

import com.aeki.ins.model.Article;

import java.math.BigInteger;

public interface InventoryDataService {
    void addArticleToInventory(String id, Article article, BigInteger quantity);
    void updateArticleQuantity(String id, BigInteger quantity);
    BigInteger getArticleQuantity(String articleId);

}
