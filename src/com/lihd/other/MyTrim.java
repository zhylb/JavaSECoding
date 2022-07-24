package com.lihd.other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/30 11:42
 */
public class MyTrim {

    public static void write(String srcFile,String desFile) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desFile));

        String s;
        while ((s = br.readLine()) != null){
            s = trim(s);
            bw.write(s);

            bw.flush();
        }

        br.close();
        bw.close();

    }

    public static String  trim(String s){
        return s.replace("  ","").replace(" ","").replace("\t","")
                .replace(";","；").replace(",","，");
    }

    public static void main(String[] args) throws Exception{
        write("src/a.txt","src/b.txt");

    }
}
