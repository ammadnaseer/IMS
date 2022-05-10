package com.aeki.ins.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class Inventory {
    String id;
    String articleId;
    String articleName;
    Number quantity;
}
