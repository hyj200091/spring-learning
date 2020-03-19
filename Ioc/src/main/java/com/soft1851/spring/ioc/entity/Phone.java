package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    private String brand;
    private Double price;
}
