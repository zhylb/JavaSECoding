package com.java09.lihd;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 10:03
 */
public class OtherTest {
    /**
     * Test01 :
     * 钻石操作符的升级
     */
    @Test
    public void test01 (){
        ArrayList<String> list = new ArrayList<>();//java7 类型推断

        //java9 钻石操作符
        Comparator<Integer> com = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }

    /**
     * Test02 : java8 新增 try()语句升级
     *
     * 1 流的声明 放在try后面的括号中 中间用分号隔开
     * 2 会保证流一定会关闭，因此不用写 fis.close()
     * 3 此时fis.fos为final,不可修改
     */
    @Test
    public void test02 (){
        try(FileInputStream fis = new FileInputStream("Hello.txt");
            FileOutputStream fos = new FileOutputStream("HelloCopy.txt")
        ){
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test03 : java9 新增 try语句再次升级
     * 0 try()中的变量一定会被关闭，不用显示写fis.close();
     * 1 try()中只存放 变量，中间用  分号隔开
     * 2 try()中的变量 是常量，哪怕出了try块，变量也不能重新赋值
     * 3 在外面声明的流可能抛出 FileNotFoundException 确实没有办法，需要抛出或处理
     * 4 个人感觉相较java8没有太大提升
     */
    @Test
    public void test03 () throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("Hello.txt");
        FileOutputStream fos = new FileOutputStream("HelloCopy.txt");
//        不能重新赋值
//        try(fis = new FileInputStream("Hello.txt");
//            fos = new FileOutputStream("HelloCopy.txt")){
        try(fis;fos){
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fis);
        // fis = null;//运行报错
    }


    /**
     * Test04 : java9  InputStream 新增 transferTo 方法 复制更简洁
     * 对test02进行升级
     * 有一个long的返回值
     *
     *
     */
    @Test
    public void test04 (){
        try(FileInputStream fis = new FileInputStream("Hello.txt");
            FileOutputStream fos = new FileOutputStream("HelloCopy.txt")
        ){
            long l = fis.transferTo(fos);
            System.out.println(l);//复制的字节个数吗
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test05 : java9  InputStream 新增 transferTo 方法 复制更简洁
     * 配合上面的test02进行升级
     * 有一个long的返回值
     *
     *
     */
    @Test
    public void test05 () throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("Hello.txt");
        FileOutputStream fos = new FileOutputStream("HelloCopy.txt");
        try(fis;fos){
            long l = fis.transferTo(fos);
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
