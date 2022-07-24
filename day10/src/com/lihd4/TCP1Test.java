package com.lihd4;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 * 似乎只有 服务器的socket.shutdown()才有效
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 18:52
 */
public class TCP1Test {
    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 ()throws Exception{
        //1 new Socket(ip,port)
        Socket socket = new Socket(InetAddress.getLocalHost(), 52013);
        InputStream is = socket.getInputStream();
        //2 socket.getInputStream
        // socket.getOutStream
        //进行流的相关操作
        FileOutputStream fos = new FileOutputStream("src/com/lihd4/file/receive.jpg");
        int len;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }

        //socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        os.write("图片已经下载好了".getBytes());
        //3 xx.close();
        os.close();
        fos.close();
        is.close();
        socket.close();



    }


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        //1 创建ServerSocket对象
        ServerSocket ss = new ServerSocket(52013);
        //2 ss.accept()获取Socket对象
        Socket accept = ss.accept();

        //3 socket.getInputStream
        // socket.getOutStream
        //进行流的相关操作
        FileInputStream fis = new FileInputStream("src/com/lihd4/file/诺艾尔.jpg");
        OutputStream os = accept.getOutputStream();
        int len;
        byte[] buffer = new byte[1024];
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        // 4 socket.shutdown终止一个输入或输出
        // 关键代码，非常重要
        accept.shutdownOutput();


        System.out.println("发送给"+ accept.getInetAddress() +" 的图片发送成功");

        InputStream is = accept.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        System.out.println("收到了来自客户端的数据 ： ");
        System.out.println(baos.toString());
        //5 xx.close();
        os.close();
        is.close();
        fis.close();
        accept.close();
        ss.close();

    }
}
