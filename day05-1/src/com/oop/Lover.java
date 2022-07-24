package com.oop;

/**
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/7 15:22
 */
public class Lover implements Loveable{
    Loveable loveable;//没有初始值
    String name;//名字
    public Lover() {
    }
    public Lover(Loveable loveable) {
        this.loveable = loveable;
    }
    public Lover(String name) {
        this.name = name;
    }

    public Lover(Loveable loveable, String name) {
        this.loveable = loveable;
        this.name = name;
    }
    //上面都是构造器上面的
    @Override
    public void love() {
        //这个方法真的是太厉害了
        if(loveable != null){
            loveable.love();
        }
    }
    public void loveStory(){
        System.out.println("loveStory");
        love();
        System.out.println("我又想你了呀");
    }
}
