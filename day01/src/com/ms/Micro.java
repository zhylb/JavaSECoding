package com.ms;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 16:17
 */
public class Micro {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,7,2,9,45,57,89};

        // 数组每个元素 除以 第一个元素后的操作


//        //错误的方式
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i]/arr[0];
//        }
//        System.out.println(Arrays.toString(arr));


        //正确的方式
        for (int i = arr.length - 1 ; i >= 0; i --) {
            arr[i] = arr[i]/arr[0];
        }
        System.out.println(Arrays.toString(arr));
    }
}
