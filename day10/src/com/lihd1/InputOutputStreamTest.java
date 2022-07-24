package com.lihd1;

import org.junit.Test;

import java.io.*;

/**
 * 请先见 ReadWriterTest
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 22:46
 */
public class InputOutputStreamTest {
    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        FileInputStream fis = new FileInputStream("src/com/lihd1/file/loveStory.jpg");
        FileOutputStream fos = new FileOutputStream("src/com/lihd1/file/sadStory.jpg");
        //方式一
//        int ch;
//        while((ch = fis.read()) != -1){
//            fos.write(ch);
//        }
        //方式二
        int len;
        byte[] buffer = new byte[1024];
        while((len = fis.read(buffer)) != -1){
            fos.write(buffer,0,len);
            fos.flush();
            System.out.println(new String(buffer,0,len));
        }


        fis.close();
        fos.close();

    }

    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src/com/lihd1/file/loveStory.jpg")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("src/com/lihd1/file/sadStory.jpg")));

        int len;
        byte[] buffer = new byte[1024];

        while((len = bis.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        bis.close();
        bos.close();
    }

}
