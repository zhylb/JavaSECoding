package com.lihd1;

import java.io.*;

/**
 * 介绍转换流
 * InputStreamReader
 * OutputStreamWriter
 * 看后缀可知是字符流
 *
 * 编码 -> OutputStreamWriter  看得懂 -》看不懂
 * 解码 -> InputStreamReader   看不懂 -》能看懂
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 23:23
 */
public class InputReaderOutputWriterTest {

    public static void main(String[] args) {
        String srcFile = "day10/src/com/lihd1/file/dbcp.txt";
        String desFile = "day10/src/com/lihd1/file/dbcp_gbk.txt";

        convert(srcFile,"utf-8",desFile,"gbk");
    }

    public static void convert(String srcFile,String srcCharset,String desFile,String desCharset){
        //别忘了加入参数，使用默认的字符集总会引起一些错误
        //new InputStreamReader(ins,String charSetName)
        //new OutputStreamWriter(ous,String charSetName)
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(srcFile))),srcCharset);
            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(new File(desFile))),desCharset);

            int len;
            char[] cbuffer = new char[1024];

            while((len = isr.read(cbuffer)) != -1){
                osw.write(cbuffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
