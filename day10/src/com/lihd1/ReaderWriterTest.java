package com.lihd1;

import org.junit.Test;

import java.io.*;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 22:46
 */
public class ReaderWriterTest {

    /**
     * Test01 : FileReader/FileWriter
     *
     * read() 一个一个char读入，读到末尾返回 -1
     * write(int c) 一个一个char写入
     *
     * 要求读入文件必须存在
     * 写出文件可以不存在，如果不存在就新建一个
     * Writer有一个append的参数
     * 如果为真，就是向后面追加而不是覆盖，默认为假
     *
     * 1 造流并关联节点（File）
     * 2 读入写出
     * 3 关闭流
     *
     */
    @Test
    public void test01 (){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("src/com/lihd1/file/a.txt");
            fw = new FileWriter("src/com/lihd1/file/b.txt",false);
            int a;
            while ((a = fr.read()) != -1){
                fw.write(a);
                fw.flush();
                System.out.println((char)a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {

                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        FileReader fr = new FileReader("src/com/lihd1/file/a.txt");
        FileWriter fw = new FileWriter("src/com/lihd1/file/b.txt");

        char[] cbuffer = new char[5];
        int len;
        while((len = fr.read(cbuffer)) != -1){
            //第一种写入方法 fw.write(cbuffer)是错误写法
            fw.write(cbuffer,0,len);

            //第二种写法 s = new String(cbuffer)是错误写法
            String s = new String(cbuffer, 0, len);
            System.out.println(s);
            //fw.write(s);
        }

        fr.close();
        fw.close();

    }

    /**
     * Test03 :
     * 必须要关闭所有流
     * 关闭外部的流会自动关闭外部流所包含的内部流
     *
     *
     */
    @Test
    public void test03 () throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("src/com/lihd1/file/a.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/com/lihd1/file/b.txt")));
        //方式一
//        char[] buffer = new char[1024];
//        int len;
//        while((len = br.read(buffer)) != -1){
//            bw.write(buffer,0,len);
//        }
        //方式二
        String s;
        while ((s = br.readLine()) != null){
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }


}
