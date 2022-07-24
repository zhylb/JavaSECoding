package com.lihd2.B;

import com.lihd2.A.Num;

/**
 * 子类可以访问 protected public 却访问不到缺省
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 19:27
 */
public class SonNum extends Num {
    public static void main(String[] args) {
        SonNum sn = new SonNum();
        System.out.println(sn.numProtected);
        System.out.println(sn.numPublic);

    }
}
