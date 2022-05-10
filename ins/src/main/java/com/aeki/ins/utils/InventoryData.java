package com.aeki.ins.utils;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class InventoryData {
    String art_id;
    String name;
    BigInteger stock;
}
