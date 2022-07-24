package com.lihd4;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一资源的地址。
 * 它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
 * 通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www， ftp站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。
 *  URL的基本结构由5部分组成：
 *      <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *      例如:
 *          http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 *          #片段名：即锚点，例如看小说，直接定位到章节
 *          参数列表格式：参数名=参数值&参数名=参数值....
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 22:39
 */
public class URLTest {


    /**
     * Test02 : 从网络上下载内容保存到本地
     *
     *
     *
     */
    @Test
    public void test02 () throws Exception{
        URL url = new URL("https://ys.mihoyo.com/main/");

        URLConnection urlConnection = url.openConnection();

        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("src/com/lihd4/file/url.txt");

        int len;
        byte[] buffer = new byte[1024];
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);

        }

        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.disconnect();
        is.close();
        fos.close();


    }

    /**
     * Test01 : 一些get方法的测试
     *
     *
     *
     */
    @Test
    public void test01 () throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/s/video/BV1rr4y1r72o");
        System.out.println("getProtocol() :"+url.getProtocol());
        System.out.println("getHost() :"+url.getHost());
        System.out.println("getPort() :"+url.getPort());
        System.out.println("getPath() :"+url.getPath());
        System.out.println("getFile() :"+url.getFile());
        System.out.println("getQuery() :"+url.getQuery());
    }


}
