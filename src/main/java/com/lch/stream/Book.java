package com.lch.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private Long id;
    private String name;
    private String category; // "哲学,爱情,个人成长,个人传记"
    private Integer score;
    private String intro;
}
