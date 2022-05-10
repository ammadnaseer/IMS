package com.aeki.ins.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
@Embeddable
public class ArticleEntity {
    String articleId;
    BigInteger articleQuantity;

}
