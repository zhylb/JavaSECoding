package com.exer;

import java.util.Arrays;

/**
 * 牢记java是值传递
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 23:00
 */
public class StringTest {
    public static void main(String[] args) {
        String name = "千里一怒";
        char[] arr = new char[]{'t','e','s','t'};
        change(name,arr);
        System.out.println(name);//千里一怒
        System.out.println(arr);//best
    }

    public static void change(String name,char[] arr){
        name = "我有何颜面见袁公";
        arr[0] = 'b';
    }
}


