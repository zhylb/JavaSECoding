package com.exer.file;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程断点复制
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 21:04
 */
public class MultiCopy {
    //线程池，最多50个线程
    private static final ExecutorService executorService = Executors.newFixedThreadPool(50);
    String srcFilePath;
    String desFilePath;
    int numThread;
    String breakPointPath;//根据两个文件名称和线程数实现断点文件
    File bpp;

    public MultiCopy(String srcFilePath,String desFilePath,int numThread){
        this.srcFilePath = srcFilePath;
        this.desFilePath = desFilePath;
        this.numThread = numThread;

        this.breakPointPath = "MuticCopy"+ (srcFilePath.hashCode()+desFilePath.hashCode()+numThread*31) + ".txt";
        this.bpp = new File(breakPointPath);
    }

    private void getBefore(){
        if(bpp.exists()){
            //读取所有的断点信息
        }
    }

    public void copy(){
        File srcFile = new File(srcFilePath);
        int len = srcFilePath.length();


        for (int i = 0; i < numThread; i++) {

        }



        System.out.println(111);

    }










}
