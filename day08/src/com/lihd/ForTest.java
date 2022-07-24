package com.lihd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * JDK5.0新增，增强for循环
 * 用于遍历容器 （Collection 和 数组）
 * 内部使用了 Iterator
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 11:30
 */
public class ForTest {



    /**
     * Test03 : 使用foreach赋值
     *
     *
     *
     */
    @Test
    public void test03 (){
        String[] str = {"AA","BB","cc"};
        for (String s : str) {
            s = "love";
        }
        System.out.println(Arrays.toString(str));
    }



    /**
     * Test02 : 使用for方式遍历数组
     * for(数组存放数据类型 局部变量 : 数组名)
     *
     *
     */
    @Test
    public void test02 (){
        String[] str = {"AA","BB","cc"};
        for (String s : str) {
            System.out.println(s);
        }

    }

    /**
     * Test01 :使用增强for循环遍历集合
     * 使用方式 for(集合元素类型 局部变量 ：集合名称)
     *
     *
     */
    @Test
    public void test01 (){
        Collection<Integer> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        for (Integer i : coll) {
            System.out.println(i);
        }

    }
}
