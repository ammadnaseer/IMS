package com.aeki.ins.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    String id;

    @Column(nullable= false)
    String name;

    @Column
    String articleId;

    @Column
    BigInteger articleQuantity;

}
