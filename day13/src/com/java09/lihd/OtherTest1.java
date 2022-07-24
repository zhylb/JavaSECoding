package com.java09.lihd;

import org.junit.Test;

import java.util.*;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 11:45
 */
public class OtherTest1 {
    /**
     * Test01 : java8 创建只读集合的方法
     * 1 Collections.unmodifiableMap 代码量较多
     * 2 Arrays.toList() 返回Arrays的内部类List
     */
    @Test
    public void test01 (){
        List<String > list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("null");
        List<String> strings = Collections.unmodifiableList(list);
        strings.stream().forEach(System.out::println);
//        strings.add("jij"); //添加会报错
        List<Integer> integers = Arrays.asList(12, 58, 63, 94);
        System.out.println(integers.getClass()); //class java.util.Arrays$ArrayList
//        integers.add(78);//添加会报错
    }

    /**
     * Test02 : java8 创建只读Map 只读set
     * Collections.unmodifiableMap
     *
     */
    @Test
    public void test02 (){
        //注意 钻石操作符使用了java9的特性

        //Map中有两个大括号，第一个是继承类的大括号，另一个是代码块的大括号
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("String", 123);
                put("hello", 456);
                put("never", 879);
            }
        });
        map.entrySet().forEach(System.out::println);
        //map.put(null,null); //不能添加元素
        //Set中有两个大括号，第一个是匿名子类，第二个是匿名子类的代码块
        Set<String > set = Collections.unmodifiableSet(new HashSet<>(){
            {
                add("hello");
                add("world");
                add("123");

            }
        });
        set.forEach(System.out::println);
        //set.add("hello");//不能添加元素
    }


    /**
     * Test03 : java9 使用Xxx.of()创建只读集合
     * Set.of() 创建只读Set
     * List.of()创建只读List
     * Map.of()创建只读Map
     * Map.ofEntries()创建只读Map
     */
    @Test
    public void test03 (){
        List<String> hello = List.of("hello", "world", "123");
        // hello.add("456"); 添加会报错
        Set<Integer> integers = Set.of(78, 56, 23, 14, 75);

        Map<String, Integer> map = Map.of("hello", 123, "world", 456, "never", 789);

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Hello", 123), Map.entry("world", 456));
    }
}
