package com.lihd1;

/**
 * IO流
 * 根据流的方向 ： 输入流 ， 输出流
 * 根据流处理的基本单位 ：字符流，字节流
 * 根据流的角色分类 ：节点流，处理流
 *
 * 抽象基类                 节点流（文件流）            缓冲流（处理流）            常用方法
 * InputStream          FileInputStream         BufferedInputStream         read(buffer) /read()
 * OutputStream         FileOutputStream        BufferedOutputStream        write(buffer,0,len)
 * Reader               FileReader              BufferedReader              read(cbuffer)/read()
 * Writer               FileWriter              BufferedWriter              write(cbuffer,0,len)
 * 一般输出流都有 flush()方法，调用后写出，一般不用手动调用
 * BufferedReader提供了  readLine()   方法
 *
 * 纯文本（.txt） ：使用字符流进行控制 可以使用字节流进行复制操作
 * 视频，word,mp3 : 使用字节流
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 22:37
 */
public class IOTest {

}
