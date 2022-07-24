package com.lihd2;

import java.io.Serializable;

/**
 * 自定义可序列化对象
 * 1 实现Serializable标识接口
 *        （没有任何方法，但是提供）
 * 2 提供serialVersionUID
 *      （如果没有会根据其属性自动提供一个值，如果类发生改变，那么改变之前被序列化的对象再也无法实例化，所以报错）
 *      提供之后，如果新增了属性，那么就使用默认值
 * 3 要求其所有的属性都支持序列化
 *      （基本数据类型包装类String都支持序列化）
 *
 * 注意 ：
 *      1 static属性无法序列化，（static属于类）(似乎支持输出)
 *      2 transient关键字修饰的属性无法序列化传输
 *      3 现在大部分采用Json数据格式（String）进行序列化
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/16 12:37
 */
public class MySerializable implements Serializable {
    //随便写的
    private static final long serialVersionUID = 427897798465465L;
    int aaa = 111222;//突然添加一个属性

    static int numStatic = 999;
    transient int numTransient;
    private int numPrivate;



    public MySerializable(int numTransient, int numPrivate) {
        this.numTransient = numTransient;
        this.numPrivate = numPrivate;
    }

    @Override
    public String toString() {
        System.out.println(aaa);
        return "MySerializable{" +
                "numTransient=" + numTransient +
                ", numPrivate=" + numPrivate +
                ", numStatic = " + numStatic + '}';
    }


}
