package com.lihd1;

import java.io.Serializable;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 15:32
 */
public class Father<T> implements Serializable {

    private int faAge;
    public String faName;

    private void faPrivate(String s,int a){
        System.out.println("s = " + s + ", a = " + a);
    }

    public String faPublic(int a){
        System.out.println("Father::faPublic");
        return "hello-" + a;
    }
}
