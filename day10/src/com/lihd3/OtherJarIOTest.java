package com.lihd3;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 实际开发中往往用到已经写好的jar包，直接用即可
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 23:02
 */
public class OtherJarIOTest {

    public static void main(String[] args) throws Exception{


        IOUtils.copy(new FileInputStream("day10/src/com/lihd3/诺艾尔.jpg"),
                new FileOutputStream("day10/src/com/lihd3/des.jpg"));
    }
}
