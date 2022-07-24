package com.lihd1;

import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/22 10:36
 */
public class MyPrint {

    private Robot robot;
    private Random random;
    private String str;
    private String strpath = "src/com/lihd1/test.txt";
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        random = new Random();
    }

    public void pressKey(){

    }

    private void getStr(String filepath){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String s;
            while((s = br.readLine()) != null){
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.str = sb.toString();
    }


    public void run(){
        System.out.println(this.str);
    }


}
