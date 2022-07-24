package com.lihd;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 10:15
 */
public class StringConvertTest {


    /**
     * Test03 : 字符串和byte数组的转换
     * 编码 ： String -> byte[] : str.getBytes()
     * 解码 ： byte[] -> String : new String(byte[])
     *
     * getBytes()或者构造器中可以指定编码的方式，
     * String(byte[])也可以指定解码的方式
     * 如果没有指定就使用默认字符集，本例中使用了utf-8
     *
     * 编码 ： 看得懂 -》看不懂
     * 解码 ： 看不懂 -》看得懂
     *
     */
    @Test
    public void test03 () throws Exception{//直接抛出异常
        String s = "123abc我爱你";

        //编码
        byte[] bytes = s.getBytes();//使用系统默认编码集
        System.out.println(Arrays.toString(bytes));//一个中文三个字节，Unicode

        byte[] gbks = s.getBytes("gbk");//使用gbk编码，一个中文两个字节
        System.out.println(Arrays.toString(gbks));

        //解码
        String s0 = new String(bytes);
        System.out.println(s0);


        String s1 = new String(bytes, "utf-8");
        System.out.println(s1);

        String s2 = new String(gbks, "utf-8");//乱码
        System.out.println(s2);

        String s3 = new String(bytes, "gbk");//乱码
        System.out.println(s3);

        String s4 = new String(gbks, "gbk");
        System.out.println(s4);
    }



    /**
     * Test02 : 字符串和char型数组的转换
     * String -> char[] : str.toCharArr();
     * char[] -> String : new String(char[])
     *
     */
    @Test
    public void test02 (){
        String str = "123abc我爱你";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        char[] hello = new char[]{'h','e','l','l','o'};
        String s = new String(hello,2,2);
        System.out.println(s);//ll
    }


    /**
     * Test01 : 字符串和基本数据类型（或包装类）的转换
     * String -> num
     *      包装类.parseXxx
     *
     * num -> String
     *      1 String.valueOf()
     *      2 ""+num
     */
    @Test
    public void test01 (){
        //String -> num
        String s = "12.4";
        double v = Double.parseDouble(s);//包装类.parseXxx
        System.out.println(v);

        //num -> String
        int a = 345;
        String s1 = String.valueOf(a);     //1 String.valueOf()
        String s2 = "" + a;        //2 ""+num
        System.out.println(s1);
        System.out.println(s2);
    }
}
