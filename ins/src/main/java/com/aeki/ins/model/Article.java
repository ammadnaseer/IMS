package com.aeki.ins.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class Article {
    String articleId;
    String name;
}
