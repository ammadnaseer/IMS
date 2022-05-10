package com.aeki.ins.persistence.repository;

import com.aeki.ins.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("Select * from product where name = ?1")
    Optional<List<ProductEntity>> findByProductName(String name);
}
