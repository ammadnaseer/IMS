package com.aeki.ins.service;

import com.aeki.ins.model.Article;

import java.math.BigInteger;

public interface InventoryService {
    public void addArticleToInventory(Article article, BigInteger stock);
}
