package com.java10.lihd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 17:03
 */
public class OtherMethod {

    /**
     * Test01 :
     * copyOf() 1.9 新增，返回一个集合的不可变集合
     * 方式 ：如果本来就不可变，直接返回
     *       如果本来可变，新建一个返回
     *
     *
     */
    @Test
    public void test01 (){
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2：
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
    }
}
