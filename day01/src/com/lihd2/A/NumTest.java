package com.lihd2.A;

/**
 * 同一个包下 可以访问 public protected 缺省
 *
 * 使用最多的就是 public private  最少的是protected 因为区分的太细致了
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 19:26
 */
public class NumTest {
    public static void main(String[] args) {
        Num n = new Num();
        System.out.println(n.numPublic);
        System.out.println(n.numProtected);
        System.out.println(n.numPublic);
    }
}
