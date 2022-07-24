package com.lihd2;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 11:53
 */
public class OtherStreamTest {

    /**
     * Test01 :
     * System.in : InputStream
     * System.out : PrintStream
     *
     *
     * System.setIn(InputStream);
     * System.setOut(PrintStream);
     *
     * 把InputStream当做一个要读入的文件
     * 把OutputStream当做一个要写出的文件
     *
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        //1 使用Scanner读取a.txt文件内容，打印到控制台

        InputStream is = new FileInputStream("src/com/lihd2/file/dbcp.txt");
        System.setIn(is);

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(sc.next());
        }

        sc.close();
        is.close();

    }

    /**
     * 在控制台输入数据，把数据放入一个文件并转为大写
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        File file = new File("day10/src/com/lihd2/file/cons.txt");
//        if(!file.exists())
//            file.createNewFile();
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if("q".equalsIgnoreCase(s)||"quit".equalsIgnoreCase(s)){
                System.out.println("谢谢使用");
                break;
            }else {
                System.out.println(s.toUpperCase());
            }
        }

        sc.close();
        ps.close();
    }


    /**
     * Test02 :
     * DataInputStream
     * DataOutputStream
     * DataOutputStream每次写出都要显示的flush();
     * DataInputStream 每次读入的数据要和写出的数据对应
     *
     *  为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
     *  数据流有两个类： (用于读取和写出基本数据类型、 String类的数据）
     *  DataInputStream 和 DataOutputStream
     *  分别“套接”在 InputStream 和 OutputStream 子类的流上
     *  DataInputStream中的方法
     * boolean readBoolean() byte readByte()
     * char readChar() float readFloat()
     * double readDouble() short readShort()
     * long readLong() int readInt()
     * String readUTF() void readFully(byte[] b)
     */
    @Test
    public void test02 () throws Exception{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/com/lihd2/file/data.obj"));
        dos.writeUTF("您好");
        dos.flush();
        dos.writeInt(123456);
        dos.flush();
        dos.writeDouble(3.1415926);
        dos.flush();
        dos.close();

    }

    /**
     * Test03 :
     */
    @Test
    public void test03 () throws Exception{
        //读入的顺序不能乱
        //java.io.UTFDataFormatException: malformed input: partial character at end
        DataInputStream dis = new DataInputStream(new FileInputStream("src/com/lihd2/file/data.obj"));
        String readUTF = dis.readUTF();
        int i = dis.readInt();
        double v = dis.readDouble();

        System.out.println("readUTF = " + readUTF);
        System.out.println("i = " + i);
        System.out.println("v = " + v);
        dis.close();
    }

}
