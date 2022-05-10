package com.aeki.ins.persistence.repository;

import com.aeki.ins.persistence.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository {
    Optional<ArticleEntity> findById(String id);
}
