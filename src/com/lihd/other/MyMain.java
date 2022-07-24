package com.lihd.other;

import java.io.Console;
import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/30 23:38
 */
public class MyMain {
    public static void main(String[] args) {
        Console cons = System.console();
        String username = cons.readLine();
        char[] password = cons.readPassword();
        String s = new String(password);
        Arrays.fill(password, (char) 0);
        password = null;
        System.out.println(username);
        System.out.println(password);
    }
}
