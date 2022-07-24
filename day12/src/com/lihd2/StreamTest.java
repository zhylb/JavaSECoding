package com.lihd2;

import com.lihd1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Stream到底是什么呢？
 * 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
 * “集合讲的是数据， Stream讲的是计算！”
 *
 * Stream 和 Collection 集合的区别： Collection 是一种静态的内存数据
 * 结构，而 Stream 是有关计算的。 前者是主要面向内存，存储在内存中，
 * 后者主要是面向 CPU，通过 CPU 实现计算
 *
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 *  1- 创建 Stream
 *      一个数据源（如：集合、数组），获取一个流
 *  2- 中间操作
 *      一个中间操作链，对数据源的数据进行处理
 *  3- 终止操作(终端操作)
 *      一旦执行终止操作， 就执行中间操作链，并产生结果。之后，不会再被使用
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 17:11
 */
public class StreamTest {
    /**
     * Test01 : 通过集合创建Stream
     */
    @Test
    public void test01 (){
        ArrayList<Person> list = Person.getList();

        Stream<Person> stream = list.stream();
        Stream<Person> personStream = list.parallelStream();

    }


    /**
     * Test02 : 通过数组创建Stream
     *
     */
    @Test
    public void test02 (){
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person[] persons = {p1,p2,p3};
        Stream<Person> stream = Arrays.stream(persons);
    }


    /**
     * Test03 : 通过Stream创建无限流
     */
    @Test
    public void test03 (){
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        Stream<Person> stream = Stream.of(p1, p2, p3);
    }

    /**
     * Test04 : 通过无限流创建对象
     */
    @Test
    public void test04 (){
        //生成10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        //
        Stream.iterate(2.0, a -> Math.pow(a, 2)).limit(5).forEach(System.out::println);
        //
        Stream.iterate(1000000.0,Math::sqrt).limit(50).forEach(System.out::println);


    }

}
