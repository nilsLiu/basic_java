package com.lch.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();

//        testFilter();
//        testMap();

//        testDistinct();

//        testSorted();

//        testLimit();

//        testSkip();

//        testFlapMap();

//        testForEach();

//        testCount();

//        testMaxMin();

//        testCollect();

//        testAnyMatch();

//        testAllMatch();

//        testNoneMatch();

//        testFindAny();

//        testFindFirst();

        testReduce();
    }

    private static void testReduce() {
        List<Author> authors = getAuthors();

        //求所有作家年龄之和
        Integer sum = authors.stream()
                .map(author -> author.getAge())
                .distinct()
                .reduce(0, (result, element) -> result + element);

        //使用reduce求所有作家中年龄最大值
        Integer max = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result > element ? result : element);

        //使用reduce求所有作家中年龄最小值
        //一个参数
        Optional<Integer> min1 = authors.stream()
                .map(author -> author.getAge())
                .reduce((result, element) -> result < element ? result : element);
        //两个参数
        Integer min2 = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result < element ? result : element);

        System.out.println(sum);
        System.out.println(max);
    }

    private static void testFindFirst() {
        List<Author> authors = getAuthors();
        //获取年龄最小的作家
        Optional<Author> first = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void testFindAny() {
        List<Author> authors = getAuthors();

        //获取任意一个大于18岁的作家
        Optional<Integer> any = authors.stream()
                .filter(author -> author.getAge() > 18)
                .map(author -> author.getAge())
                .findAny();
        System.out.println(any.get());
    }

    private static void testNoneMatch() {
        //判断作家是否都未超过100岁
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(flag);
    }


    private static void testAllMatch() {
        //判断是否所有作家都是成年人
        List<Author> authors = getAuthors();
        boolean isExist = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(isExist);
    }

    private static void testAnyMatch() {
        // 判断是否有年龄在29岁以上的作家
        List<Author> authors = getAuthors();
        boolean isExist = authors.stream()
                .map(author -> author.getAge())
                .anyMatch(age -> age > 29);
        System.out.println(isExist);

    }

    private static void testCollect() {
        //获取一个存放所有作者名字的List集合
        List<Author> authors = getAuthors();
        List<String> nameList = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());

        //获取一个所有书名的Set集合
        Set<String> bookNameSet = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .collect(Collectors.toSet());

        //获取一个Map集合，map的key为作者名，value为List<book>
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        System.out.println(nameList);
        System.out.println(bookNameSet);
        System.out.println(map);
    }


    private static void testMaxMin() {
        //分别获取这些作家的所出书籍的最高分和最低分
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        System.out.println(max.get());
    }

    private static void testCount() {
        //打印这些作家所有书籍的数目，去重
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void testForEach() {
        //打印所有作家的名字
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void testFlapMap() {
        //打印所有书籍的名字。要求对重复的元素进行去重2
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

        //打印现有数据的所有分类。要求对分类去重。不能出现这种格式：哲学,爱情
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }

    private static void testSkip() {
        //打印除了年龄最大的作家之外的其他元素，作家年龄降序排序，且要求无重复元素
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void testLimit() {
        //对作家年龄降序排序，且要求无重复元素，打印年龄最大的两个作家姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void testSorted() {
        //打印按年龄排序的所有作家的姓名，且无重复
        List<Author> authors = getAuthors();
//        authors.stream()
//                .distinct()
//                .sorted()
//                .forEach(author -> System.out.println(author.getName() + ":" + author.getAge()));

        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(author -> System.out.println(author.getName() + ":" + author.getAge()));
    }

    private static void testDistinct() {
        //打印所有作家的姓名，且无重复
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }


    private static void testMap() {
        //打印所有作家的姓名
        List<Author> authors = getAuthors();
//        authors.stream()
//                .map(author -> author.getName())
//                .forEach(s -> System.out.println(s));
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(age -> System.out.println(age));
    }

    private static void testFilter() {
        List<Author> authors = getAuthors();
        //打印所有名字长度大于1的作家的姓名
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;

    }
}
