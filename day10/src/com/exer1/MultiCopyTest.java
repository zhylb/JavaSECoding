package com.exer1;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 11:27
 */
public class MultiCopyTest {
    public static void main(String[] args){
        String srcFile = "day10/file/诺艾尔.jpg";
        String desFile = "day10/file/诺艾尔4.jpg";

        MultiCopy multiCopy = new MultiCopy(srcFile, desFile, 100, 10);
        multiCopy.multiCopy();

    }
}
