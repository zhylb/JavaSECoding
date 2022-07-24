package com.lihd;

import java.io.File;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 20:53
 */
public class FileUtils {
    public static void main(String[] args) {
        String path = "D:\\CodeWorkspace\\JavaWorkspace\\JavaSE\\JavaSECoding\\";
        showFile(new File(path),".java");

        //已经验证过结果，没有问题
        long l = fileSize(new File(path), "");
        System.out.println(l);
    }

    public static void showFile(File file,String endwith){
        if(file.isDirectory()){
            System.out.println("--------------------");
            File[] files = file.listFiles();
            for (File f : files) {
                showFile(f,endwith);
            }
            System.out.println("--------------------");

        }else {
            if(file.toString().endsWith(endwith))
                System.out.println(file);
        }

    }

    public static long fileSize(File file,String endwith){
        long l = 0;
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                l += fileSize(f,endwith);
            }
            return l;
        }else {
            if(file.toString().endsWith(endwith))
                l = file.length();
        }
        return l;
    }

}
