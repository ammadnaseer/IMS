package com.aeki.ins.rest;

import lombok.*;

import java.math.BigInteger;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class AvailableProducts {
    String name;
    BigInteger quantityAvailable;
}
