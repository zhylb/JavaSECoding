package com.lihd2.B;

import com.lihd2.A.Num;

/**
 * 不同包下 只能访问 public
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 19:28
 */
public class OtherNum {
    public static void main(String[] args) {
        Num num = new Num();
        System.out.println(num.numPublic);
    }
}
