package com.stschool.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String name;
    private boolean isAvailable;
}