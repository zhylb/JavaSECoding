package com.lihd4;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 22:20
 */
public class UDPTest {

    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        //1 提供DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();
        //提供要发送的数据
        byte[] bytes = "我已经爱上你".getBytes();
        //提供DatagramPacket对象 传入data,IP 和 port
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),7777);
        //发送数据
        ds.send(dp);

        ds.close();
    }

    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 ()throws Exception{
        //1 new DatagramSocket(int port)指定端口
        DatagramSocket ds = new DatagramSocket(7777);
        //2 提供一个字节数组
        byte[] buffer = new byte[1024];
        //3 DatagramPacket dp 存放数据
        DatagramPacket dp = new DatagramPacket(buffer,0,buffer.length);

        //4 接收数据
        ds.receive(dp);
        //dp.getData() 获取数据
        //dp.getLength() 获取数组长度
        String s = new String(dp.getData(),0, dp.getLength());
        System.out.println(s);

        ds.close();

    }
}
