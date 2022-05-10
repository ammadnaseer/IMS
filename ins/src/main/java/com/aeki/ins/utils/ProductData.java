package com.aeki.ins.utils;

import lombok.*;

import java.math.BigInteger;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class ProductData {
    String name;
    List<ContainedArticles> contain_articles;



    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @With
    static class ContainedArticles{
        String art_id;
        BigInteger amount_of;
    }

}
