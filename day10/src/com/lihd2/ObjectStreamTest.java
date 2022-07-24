package com.lihd2;

import org.junit.Test;

import java.io.*;

/**
 *  ObjectInputStream和OjbectOutputSteam
 *  用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
 * 以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *  序列化： 用ObjectOutputStream类保存基本类型数据或对象的机制
 *  反序列化： 用ObjectInputStream类读取基本类型数据或对象的机制
 *  ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 12:40
 */
public class ObjectStreamTest {

    /**
     * Test01 : 序列化
     *
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/lihd2/file/obj.dat"));

        oos.writeObject(new MySerializable(11,22));

        oos.writeInt(123);

        oos.close();

    }

    /**
     * Test02 : 反序列化
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/lihd2/file/obj.dat"));

        Object o = ois.readObject();
        int i = ois.readInt();
        System.out.println(o);
        System.out.println(i);

    }
}
