package com.lihd;



/**
 * 枚举类 ：对象是有限，确定的
 * 如果枚举类只有一个对象，可以视为单例模式
 * 枚举类 可以放在Switch中
 *
 *
 *
 * 自定义一个枚举类
 * 1 私有化构造器
 * 2 提供属性 private final
 * 3 提供公共的对象 public final
 * 4 其他诉求 ：getXxx 或者 toString
 * 5 自己定义的枚举类似乎无法被switch -case
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 15:04
 */
public class MyEnumTest {
    public static void main(String[] args) {
        Study study = Study.HAPPY;
        System.out.println(study);


    }

}

class Study{
    //1
    private final String desc;
    private final String feeling;

    //2
    private Study(String desc, String feeling) {
        this.desc = desc;
        this.feeling = feeling;
    }

    //3
    public static final Study SAD = new Study("失落","感觉自己很难受");
    public static final Study GAME = new Study("游戏瘾","非常想打游戏");
    public static final Study NONE = new Study("躺平","什么也不想做");
    public static final Study HAPPY = new Study("开心","感学习使我快乐");


    public String getDesc() {
        return desc;
    }

    public String getFeeling() {
        return feeling;
    }

    @Override
    public String toString() {
        return "Study{" +
                "desc='" + desc + '\'' +
                ", feeling='" + feeling + '\'' +
                '}';
    }


}