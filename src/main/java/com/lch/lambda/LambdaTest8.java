package com.lch.lambda;

import com.lch.stream.Author;
import com.lch.stream.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest8 {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(Author::getName)
                .map(StringBuffer::new)
                .map(sb -> sb.append("-hai").toString())
                .forEach(System.out::println);

//        authors.stream()
//                .map(author -> author.getAge())
//                .map(age -> age + 10)
//                .filter(age -> age > 18)
//                .map(age -> age +2)
//                .forEach(System.out::println);

        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age -> age > 18)
                .map(age -> age +2)
                .forEach(System.out::println);

    }

    private static List<com.lch.stream.Author> getAuthors() {
        com.lch.stream.Author author1 = new com.lch.stream.Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        com.lch.stream.Author author2 = new com.lch.stream.Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        com.lch.stream.Author author3 = new com.lch.stream.Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        com.lch.stream.Author author4 = new com.lch.stream.Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        //书籍列表
        List<com.lch.stream.Book> books1 = new ArrayList<>();
        List<com.lch.stream.Book> books2 = new ArrayList<>();
        List<com.lch.stream.Book> books3 = new ArrayList<>();

        books1.add(new com.lch.stream.Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new com.lch.stream.Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new com.lch.stream.Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new com.lch.stream.Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new com.lch.stream.Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new com.lch.stream.Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new com.lch.stream.Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;

    }
}
