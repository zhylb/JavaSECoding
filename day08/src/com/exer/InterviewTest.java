package com.exer;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * 小启发 ： 当你觉得一个方法很合理，很应该出现在一个类中的时候，
 *  --- 你会发现这个方法确实存在于这个类中，这就是爱
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 21:08
 */
public class InterviewTest {


    /**
     * Test03 : 给一个文本，文本间用空格隔开(可能有换行)，请将其转换为不包含重复单词的List
     *
     *
     *
     */
    @Test
    public void test03 (){
        String s = """
                I love three things the sun the moon and you 
                The sun is for the day the moon is for the night 
                and you forever 
                """;
        //s.replace去掉空格后 spilt()
        String[] strs = s.replace("\r", "").split(" ");

        //arr[] -> list
        List<String> list = Arrays.asList(strs);

        //list -> set
        Set set = new HashSet(list);

        //set -> list
        List<String> list1 = new ArrayList<>(set);

        list1.stream().forEach(System.out::println);

        //如何简化

        ArrayList list2 = new ArrayList<>(new HashSet(Arrays.asList(s.replace("\n", "").split(" "))));
        System.out.println(list2);


    }


    /**
     * Test02 : 获取一个文件的java关键字个数
     * 介绍几个好用的方法
     * map.getOrDefault()
     * map.putIfAbsent()
     * Arrays.asList()
     */
    @Test
    public void test02 () throws Exception{
        //首先把一个字符串改为数组
        String[] split = "abstract,assert,boolean,break,byte,case,catch,char,class,continue,default,do,double,else,enum,extends,final,finally,float,for,if,implements,import,int,interface,instanceof,long,native,new,package,private,protected,public,return,short,static,strictfp,super,switch,synchronized,this,throw,throws,transient,try,void,volatile,while".split(",");
        //使用Array.asList(arr)把数组转换为collection并放入set中
        Set<String> keywords = new HashSet<>(Arrays.asList(split));
        Map<String,Integer> resultMap = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("src/com/lihd3/Person.java")));
        String s;
        while (sc.hasNext()){
            s = sc.next();
            if (keywords.contains(s)) {
//                if(resultMap.get(s) == null) resultMap.put(s,1);
//                else resultMap.put(s,resultMap.get(s) + 1);

                resultMap.put(s, resultMap.getOrDefault(s,0) + 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = resultMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "\t\t\t" + next.getValue());
        }

    }


    /**
     * Test01 : 请写出每一步的打印结果（共四步）
     * 为什么结果是这样的
     *
     * 启发是什么
     * 对于存放到map和set中的元素，最好不要对其进行修改（map中对应的是key，key不可随意修改），因为这会影响哈希值的计算结果和equals()的结果
     * 更为重要的是，这相当于把一个元素放到了错误的位置，如果属性不修改，那么就无法remove()掉这个元素
     * 如果确实要修改，建议先remove,然后再放入一个新的
     *
     */
    @Test
    public void test01 (){
        //声明 ：Person类中正确的重写了hashCode()和equals()方法
        Set<Person> set = new HashSet();
        Person p1 = new Person("AA",11);
        Person p2 = new Person("BB",22);
        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person{name='BB', age=22}, Person{name='AA', age=11}]
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//[Person{name='BB', age=22}, Person{name='CC', age=11}]

        set.add(new Person("CC",11));//[Person{name='BB', age=22}, Person{name='CC', age=11}, Person{name='CC', age=11}]
        System.out.println(set);

        set.add(new Person("AA",11));//
        System.out.println(set);//[Person{name='BB', age=22}, Person{name='CC', age=11}, Person{name='CC', age=11}, Person{name='AA', age=11}]

    }
}
