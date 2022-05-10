package com.aeki.ins.utils;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class Inventory {
    List<InventoryData> inventory;
}
