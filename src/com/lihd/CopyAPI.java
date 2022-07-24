package com.lihd;

import java.io.*;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 9:50
 */
public class CopyAPI {

    public static void main(String[] args) throws Exception{
        String srcPath = "src/a.txt";
        String desPath = "src/b.txt";

        copyAPI(srcPath,desPath);

    }

    public static void copyAPI(String srcPath,String desPath)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desPath));

        String s;
        int count = 0;
        while((s = br.readLine()) != null){
            count++;
            bw.write(s);
            if(count % 3 != 0){
                bw.write("\t\t");
            }else {
                bw.newLine();

            }
        }
        br.close();
        bw.close();
    }


}
