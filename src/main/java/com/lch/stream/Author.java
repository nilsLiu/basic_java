package com.lch.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {
    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Book> books;

    public Author() {

    }


    @Override
    public int compareTo(Author o) {
        return this.getAge() - o.getAge();
    }
}

