package com.ms;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 16:14
 */
public class ArrayPrintTest {

    public static void main(String[] args) {

        //这是因为System.out.println()重写了 参数为char[]的方法

        int[] arr = new int[]{1,2,3};
        System.out.println(arr);//[I@1b6d3586 -> println(Object)

        char[] chars = new char[]{'a','b','c'};
        System.out.println(chars);//abc -> println(char[])


    }
}
