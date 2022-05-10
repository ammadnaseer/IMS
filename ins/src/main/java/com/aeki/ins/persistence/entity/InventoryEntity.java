package com.aeki.ins.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity(name = "inventory")
public class InventoryEntity {
    @Id
    String id;
    @Column
    String articleId;
    @Column
    String articleName;
    @Column
    BigInteger stock;
}
