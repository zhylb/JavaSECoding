package com.lihd1;

/**
 * 自定义异常步骤
 * 1 继承与 Exception 或 RuntimeException
 * 2 提供serialVersionUID 序列化中用于标志是否是同一个类
 * 3 提供构造器
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 21:03
 */
public class LoveYouException extends RuntimeException{
    private static final long serialVersionUID = -827856973823710492L;

    public LoveYouException() {
    }

    public LoveYouException(String message) {
        super(message);
    }
}
