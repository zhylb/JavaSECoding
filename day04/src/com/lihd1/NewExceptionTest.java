package com.lihd1;

import java.io.FileNotFoundException;

/**
 * 异常的产生方式 自动产生 手动new 这里蛀牙介绍new
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 20:59
 */
public class NewExceptionTest {

    public static void main(String[] args) {
        //这里的异常更像是一个普通的对象
        FileNotFoundException notFound = new FileNotFoundException("我没找到文件啊");
        System.out.println(notFound.getMessage());
        notFound.printStackTrace();


    }
}
