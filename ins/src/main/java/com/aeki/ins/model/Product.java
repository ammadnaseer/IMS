package com.aeki.ins.model;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class Product {
    String id;
    String name;
    String articleId;
    BigInteger quantity;


}
