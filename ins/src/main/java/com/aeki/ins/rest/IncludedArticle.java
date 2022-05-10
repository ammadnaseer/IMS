package com.aeki.ins.rest;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class IncludedArticle {
    String articleId;
    BigInteger quantity;
}
