package com.lihd2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet中比较一个对象是否相等不再使用equals()而是CompareTo
 * 如果两个对象CompareTo返回0，即视为相等，那就会采用先来后到，后来的元素无法加入
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 19:47
 */
public class TreeSetTest {
    
    /**
     * Test04 : 
     * 采用先来后到的机制 可以去看看TreeMap哦，比较有意思
     *
     *
     */
    @Test
    public void test04 (){
        //只按年龄排序，姓名一样我不要了
        Set<Person> set = new TreeSet(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });
        Person p1 = new Person("AA",33);
        Person p2 = new Person("BB",33);
        Person p3 = new Person("CC",33);
        Person p4 = new Person("DD",28);
        Person p5 = new Person("FF",28);

        //Person{name='DD', age=28}
        //Person{name='AA', age=33}

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);

        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    /**
     * Test03 :
     * 放入TreeSet中的数据要实现Comparable接口 或者传入Comparator接口
     * 下面演示实现Comparable
     *
     */
    @Test
    public void test03 (){
        TreeSet<Person> set = new TreeSet<>();
        set.add(new Person("AA",20));
        set.add(new Person("BB",20));
        set.add(new Person("CC",21));
        set.add(new Person("BB",18));
        set.add(new Person("AA",18));
        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    /**
     * Test02 : 放入自定义类
     * 放入TreeSet中的数据要实现Comparable接口 或者传入Comparator接口
     * 下面演示传入Comparator
     *
     */
    @Test
    public void test02 (){
        TreeSet<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //先按年龄，后按姓名
                if(o1.age == o2.age){
                    return o1.name.compareTo(o2.name);
                }else {
                    return Integer.compare(o1.age,o2.age);
                }
            }
        });
        set.add(new Person("AA",20));
        set.add(new Person("BB",20));
        set.add(new Person("CC",21));
        set.add(new Person("BB",18));
        set.add(new Person("AA",18));

        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * Test01 : 放入包装类
     *
     *
     *
     */
    @Test
    public void test01 (){
        TreeSet<Integer> set = new TreeSet();
        set.add(123);
        set.add(62);
        set.add(96);
        set.add(888);
        set.add(32);
        System.out.println(set);//[32, 62, 96, 123, 888]

        TreeSet<Integer> set1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });
        set1.add(123);
        set1.add(62);
        set1.add(96);
        set1.add(888);
        set1.add(32);
        System.out.println(set1);//[888, 123, 96, 62, 32]

    }
}
