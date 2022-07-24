package com.lihd3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 了解即可
 * 1 实例化
 * 2 load
 * 3 getProperties
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 16:59
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception{

        BufferedInputStream bis =  new BufferedInputStream(new FileInputStream("day08/src/jdbc.properties"));
        Properties properties = new Properties();
        properties.load(bis);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
