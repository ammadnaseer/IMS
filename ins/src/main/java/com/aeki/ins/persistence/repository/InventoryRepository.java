package com.aeki.ins.persistence.repository;

import com.aeki.ins.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {
    Optional<InventoryEntity> findById(String id);

    @Modifying
    @Query("update inventory i set i.stock =?2 where i.articleId = ?1 ")
    void update(String id, BigInteger quanity);

    @Query("select stock from inventory where article_id = ?1 ")
    BigInteger getArticleStock(String id);
}
