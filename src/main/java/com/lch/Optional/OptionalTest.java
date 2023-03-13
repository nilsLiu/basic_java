package com.lch.Optional;

import com.lch.stream.Author;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class OptionalTest {
    public static void main(String[] args) {

        Optional<Author> authorOptional = getAuthorOptional();
        Author author1 = authorOptional.orElseGet(() -> new Author());
        try {
            Author author2 = authorOptional.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("数据为null"));
            System.out.println(author2);
        } catch (Throwable e) {
            e.printStackTrace();
        }

//        testFilter();

//        testIsPresent();

        testMap();
    }

    private static void testMap() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.map(author -> author.getName())
                .ifPresent(name -> System.out.println(name));
    }

    private static void testIsPresent() {
        Optional<Author> authorOptional = getAuthorOptional();
        if (authorOptional.isPresent()) {
            System.out.println(authorOptional.get().getName());
        }
    }

    private static void testFilter() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.filter(author -> author.getAge() > 10)
                .ifPresent(author -> System.out.println(author.getAge()));

    }

    private static Optional getAuthorOptional() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }

    private static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return author;
    }
}
