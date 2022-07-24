package com.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 13:09
 */
public class IOUtilsTest {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(12, 47, 69, 32, 45, 67);
//        IOUtils.writeObjectList(integers,"day10/src/com/exer/file/a.dat");
        List<Integer> objectList = IOUtils.getObjectList(Integer.class, "day10/file/诺艾尔2.jpg_MultiDownload_tmp");
        System.out.println(objectList);
    }
}
