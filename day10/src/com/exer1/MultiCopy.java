package com.exer1;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 11:20
 */
public class MultiCopy {
    private String srcFile;
    private String desFile;
    private int sleepTime;
    private int threadNum;

    public MultiCopy(String srcFile, String desFile, int sleepTime, int threadNum) {
        this.srcFile = srcFile;
        this.desFile = desFile;
        this.sleepTime = sleepTime;
        this.threadNum = threadNum;

        try {
            preparedWorking();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private int[] downloadArr;
    private String tempFile;

    private int gap;

    private long allCount;


    private void preparedWorking() throws Exception {
        this.tempFile = desFile + "_MultiDownload_tmp";

        //预处理工作
        File file = new File(srcFile);
        long fileLen = file.length();

        //步长
        gap = (int) (fileLen / threadNum);
        //如果除不尽，就多开启一个线程
        if (fileLen % threadNum != 0) {
            threadNum ++;
        }
        downloadArr = new int[threadNum];
        Arrays.fill(downloadArr,0);

        System.out.println("threadNum = " + threadNum);

        File temp = new File(tempFile);
        if(temp.exists()&&temp.length()!=0){

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tempFile));
            Object o;
            for (int i = 0; i < downloadArr.length; i++) {
                downloadArr[i] = (int) ois.readObject();
                System.out.println(downloadArr[i]);
            }
            ois.close();
        }
        writeArr();

    }

    private void writeArr(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(tempFile));
            for (int i = 0; i < downloadArr.length; i++) {
                oos.writeObject(downloadArr[i]);
                oos.flush();
            }
            oos.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void multiCopy(){
        int i = threadNum - 1;
        new copyThread(i,i * gap + downloadArr[i],new File(desFile).length()).start();
        for (i = 0; i < threadNum - 1; i++) {
            new copyThread(i,i * gap + downloadArr[i],(i + 1)*gap).start();
        }
    }

    private class copyThread extends Thread {

        int index;
        long begin;
        long end;

        public copyThread(int index, long begin, long end) {
            this.index = index;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            RandomAccessFile raf1 = null;
            RandomAccessFile raf2 = null;
            try {
                raf1 = new RandomAccessFile(srcFile,"r");
                raf2 = new RandomAccessFile(desFile,"rw");
                raf1.seek(begin);
                raf2.seek(begin);
                byte[] buffer = new byte[1024];
                int len;
                long curCount = 0;
                while(curCount + begin < end &&((len = raf1.read(buffer)) != -1)){
                    raf2.write(buffer,0,len);
                    downloadArr[index] += len;
                    curCount += len;
                    allCount ++;
                    if(allCount % 10 == 0){//每写入十次就更新文件中的数组
                        writeArr();
                    }
                    System.out.println(getName() +" ：已完成"+100*(curCount + begin)/(end+0.0) + "%");
                    Thread.sleep(sleepTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (raf1 != null) {

                        raf1.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (raf2 != null) {

                        raf2.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
