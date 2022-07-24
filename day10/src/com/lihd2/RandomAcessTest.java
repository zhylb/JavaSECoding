package com.lihd2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 15:13
 */
public class RandomAcessTest {

    /**
     * Test01 :
     * 使用RandomAccessFile实现文件复制
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        RandomAccessFile raf = new RandomAccessFile("src/com/lihd2/file/loveStory.jpg","r");
        RandomAccessFile raf1 = new RandomAccessFile("src/com/lihd2/file/sadStory.jpg","rw");


        int len;
        byte[] buffer = new byte[1024];

        while(( len = raf.read(buffer)) != -1){
            raf1.write(buffer,0,len);
        }

        raf.close();
        raf1.close();
    }


    /**
     * Test02 : 实现 插入操作
     * 在一个文本文件第3个位置插入一个 Hello World
     * ByteArrayOutputStream
     * ByteArrayInputStream
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        RandomAccessFile raf = new RandomAccessFile("src/com/lihd2/file/random.txt","rw");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //指针移动到相应位置
        raf.seek(3);

        //取出这个位置后的所有元素
        int len;
        byte[] buffer = new byte[1024];
        while((len = raf.read(buffer)) != -1){
                baos.write(buffer,0,len);
        }

        //指针调整到正确位置
        raf.seek(3);
        //写入HelloWorld
        raf.write("Hello World!".getBytes());
        //写回文件
        raf.write(baos.toByteArray());


        //关闭文件
        raf.close();

    }


    /**
     * Test03 : 多线程断点下载
     *
     *
     *
     */
    @Test
    public void test03 (){

    }


}
