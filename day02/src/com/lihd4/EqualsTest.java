package com.lihd4;

import java.util.Date;

/**
 * == 与 equals
 *
 * 0 equals在Object类中的实现
 *      public boolean equals(Object obj) {
 *          return (this == obj);
 *      }
 *
 * 1 ==
 *      对于基本数据类型 比较的是值是否相等
 *      对于引用数据类型 比较的是地址值是否相等
 * 2 equals()
 *      只有引用数据类型才可以调用, 基本数据类型无法使用
 *      如果没有重写equals 内部是 == 比较的是地址值
 *      如果重写了equals方法 要看具体实现的方法, 一般比较的是"实体内容"
 *
 * 3 对于自定的类, 如果需要使用equals() 方法, 一般需要重写, 根据具体的要求
 *      书写equals(), 一般地,比较的是"实体内容"
 * 4 java中 String date file 包装类都重写了
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 17:23
 */
public class EqualsTest {
    public static void main(String[] args) {
        //基本数据类型
        System.out.println("12 == 12.0 : " + (12 == 12.0));
        System.out.println("A == 65 : "+('A' == 65));

        //引用数据类型
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        Date date1 = new Date(123456789L);
        Date date2 = new Date(123456789L);
        System.out.println(date1 == date2);
        System.out.println(date1.equals(date2));

        System.out.println("-------------------------------");
        //测试equals 和 toString
        User u1 = new User("钟离",5000);
        User u2 = new User("钟离",5000);
        System.out.println(u1.equals(u2));
    }
}
