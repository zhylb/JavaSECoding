package com.lihd2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 * 如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * Comparable和Comparator的区别
 * Comparable 在class后实现Comparable接口带泛型， 可以多次使用，规则也是确定的
 * Comparator 新的接口，可以使用泛型创建一个类的比较方法，一般单次使用（所以可能是匿名），规则根据需要
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 12:57
 */
public class CompareTest {




    /**
     * Test03 : 实现Comparator接口
     *
     * 背景：
     * 当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，
     * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
     * 那么可以考虑使用 Comparator 的对象来排序
     *
     * 如果 o1 > o2  返回 正整数
     * 如果 o1 < o2  返回 负整数
     * 如果 o1 = o2  返回 0
     * 隐含要求 ： o1 = o2返回0时，equals方法需要返回相等
     *
     *
     */
    @Test
    public void test03 (){
        Person p1 = new Person("CC",72);
        Person p2 = new Person("AA",89);
        Person p3 = new Person("DD",18);
        Person p4 = new Person("CC",89);
        Person p5 = new Person("BB",18);

        Person[] arr = {p1,p2,p3,p4,p5};

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return Integer.compare(o1.getAge(), o2.getAge());
                }

            }
        });
        System.out.println(Arrays.toString(arr));


    }



    /**
     * Test02 : 实现comparable接口，重写compareTo方法
     *
     * 重写要求 ：按需要定义对象的大小 之后
     * 如果 this > other  返回 正整数
     * 如果 this < other  返回 负整数
     * 如果 this = other  返回 0
     * 隐含要求 ： this = other返回0时，equals方法需要返回相等
     *
     *
     */
    @Test
    public void test02 (){

        Person p1 = new Person("CC",72);
        Person p2 = new Person("AA",89);
        Person p3 = new Person("DD",18);
        Person p4 = new Person("CC",89);
        Person p5 = new Person("BB",18);

        Person[] arr = {p1,p2,p3,p4,p5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    /**
     * Test01 :
     * String,包装类中实现了Comparable接口，重写CompareTo方法
     * 调用Arrays.sort(arr);后会按从小到大排序
     *
     *
     */
    @Test
    public void test01 (){
        String[] strs = {"ZZ","XX","CC","VV","BB"};
        Arrays.sort(strs);//要求实现Comparable接口
        System.out.println(Arrays.toString(strs));
    }
}
