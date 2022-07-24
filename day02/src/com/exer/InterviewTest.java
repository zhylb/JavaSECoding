package com.exer;

import org.junit.Test;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 9:30
 */
public class InterviewTest {


    /**
     * Test03 : Integer缓存的测试
     *
     *
     *
     */
    @Test
    public void test03 (){
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);//false


        //因为 Integer 有一个静态内部类 IntegerCache
        //这个类有一个Integer数组 cache
        //这个数值保存了 -128 -- 127 所有的Integer对象
        //使用自动装箱时, 这个范围内的值会直接采用这个数组中的值
        Integer i3 = 1;
        Integer i4 = 1;
        System.out.println(i3 == i4);//true


        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);//false

        //-----------------------------------
        //下面的原理类似
        Short s1 = 1;
        Short s2 = 1;
        System.out.println(s1 == s2);//true

        Long l1 = 1L;
        Long l2 = 1L;
        System.out.println(l1 == l2);//true


        //没有缓存的内部类哦
        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1 == d2);//false


        //有意思
        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);//true;


        Boolean b3 = new Boolean(true);
        Boolean b4 = new Boolean(true);
        System.out.println(b3 == b4);//false

    }


    /**
     * Test02 : if-else
     *
     *
     *
     */
    @Test
    public void test02 (){
        Object o;
        if(true){
            o = new Integer(1);
        }else {
            o = new Double(2.0);
        }
        System.out.println(o);//1 没有什么疑问
    }


    /**
     * Test01 : 三元运算符
     *
     *
     *
     */
    @Test
    public void test01 (){
        Object o = true ? new Integer(1) : new Double(2.0);

        //因为三元运算符要求两边的返回值可以统一为一种类型
        //因此提升为Double, 结果是1.0

        System.out.println(o);//1.0
    }
}
