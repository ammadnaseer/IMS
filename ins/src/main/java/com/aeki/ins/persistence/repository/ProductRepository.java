package com.aeki.ins.persistence.repository;

import com.aeki.ins.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<List<ProductEntity>> findByName(String name);
    Optional<List<String>> findAllDistinctByName(String name);
    @Query("SELECT DISTINCT name AS productName FROM  ProductEntity product")
    Set<String> findAllName();
}
