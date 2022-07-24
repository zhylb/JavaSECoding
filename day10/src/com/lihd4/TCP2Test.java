package com.lihd4;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端给服务器发送一句话 并且加密
 * 服务器 解密后把这句话转为大写 加密后发送给客户端
 * 客户端输出解密前和解密后的数据
 *
 * 加密可以只是 一个很简单的处理 比如 byte ^ 3;
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 19:19
 */
public class TCP2Test {

    //加密算法
    public byte[] change(byte[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 2786;
        }
        return arr;
    }

    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 () throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(), 52013);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //先写出
        byte[] send = change("i wanna touch the sky".getBytes());
        os.write(send);
        socket.shutdownOutput();
        int len;
        byte[] buffer = new byte[1024];

        while((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        System.out.println("解密前");
        System.out.println(baos.toString());
        byte[] change = change(baos.toByteArray());
        System.out.println("解密后");
        System.out.println(new String(change));

    }


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        ServerSocket ss = new ServerSocket(52013);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[1024];

        while((len = is.read(buffer)) != -1){
            change(buffer);
            baos.write(buffer,0,len);
        }
        //socket.shutdownInput();

        String s = baos.toString().toUpperCase();
        System.out.println("转换为大写后 ：" + s);

        //先加密，后写出
        os.write(change(s.getBytes()));

        os.close();
        is.close();
        baos.close();
        socket.close();
        ss.close();


    }
}
