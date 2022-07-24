package com.lihd;

import java.util.Arrays;

/**
 * 枚举类的定义可以非常简单
 * 向下面的Lover
 * Thread中的Thread.State也是一个枚举类，定义也非常简单
 * 但是通过三个常用方法就可以满足大部分需要
 * values valueOf toString
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 15:37
 */
public class SmallEnumTest {
    public static void main(String[] args) {
        Lover[] values = Lover.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        Lover zhangshujie = Lover.valueOf("ZHANGSHUJIE");
        System.out.println(zhangshujie);

        Thread.State[] values1 = Thread.State.values();
        System.out.println(Arrays.toString(values1));
    }

}
enum Lover{
    BAIHAN,
    CUIHUI,
    ZHANGSHUJIE,
    ZHANGQING;
}