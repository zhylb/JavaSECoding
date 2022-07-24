package com.java09.lihd1;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 新增了四个方法
 * Stream API 新增方法
 * 1 takeWhile 属于中间操作
 * 2 dropWhile 属于中间操作 + 与 takeWhile 互补
 * 3 ofNullable 属于创建操作
 * 4 iterate 重载 属于无限流 之前一般与 limit 搭配使用
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 17:06
 */
public class StreamTest {

    /**
     * Test01 :
     *
     */
    @Test
    public void test01 (){
        List<Integer> list = List.of(14, 63, 24, 96, 58, 24, 136, 42, 17);
        //获取满足的条件的元素，一旦不满足不在向下判断
        list.stream().takeWhile(a -> a < 90).forEach(System.out::println);
        //一直判断直到出现一个不满足的元素，之后获取其所有元素
        System.out.println("---------------------");
        list.stream().dropWhile(a -> a < 90).forEach(System.out::println);
        //与filter的区别
        System.out.println("---------------------");
        list.stream().filter(a -> a < 90).forEach(System.out::println);
    }


    /**
     * Test02 : null
     * Stream.of 可以存放多个null值
     * Stream.of 存放一个null值报错
     * Stream.ofNullable 可以存放一个null值，也可以存放正常值
     *   注意，这个方法只能放一个值
     *
     *
     */
    @Test
    public void test02 (){
        Stream<Object> stream = Stream.of(null, null, null);
        stream.forEach(System.out::println);

        // Stream<Object> stream1 = Stream.of(null); 创建时报错

        Stream<Object> stream1 = Stream.ofNullable(null);
        stream1.forEach(System.out::println);

        Stream<String> hello = Stream.ofNullable("hello");
        hello.forEach(System.out::println);


    }


    /**
     * Test03 : Optional.stream()方法的使用
     *
     *
     *
     */
    @Test
    public void test03 (){
        List<String> aa = List.of("AA", "CC", "EE", "DD", "BB");
        Optional<List<String>> aa1 = Optional.ofNullable(aa);
        aa1.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
