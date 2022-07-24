package com.lihd2;

/**
 * 静态代理
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 16:02
 */
public class ProxyTest {

    public static void main(String[] args) {
        Fish fish = new Fish(new Profession());
        fish.show();
    }
}


interface Playable{
    void play();
}


class Profession implements  Playable{

    @Override
    public void play() {
        System.out.println("表现出 非常专业的技术 场均输出54%");
    }
}

class Fish implements Playable{


    Playable player;

    public Fish(Playable player){
        this.player = player;
    }

    public void show(){
        call();
        select();
        play();
        end();
    }


    public void call(){
        System.out.println("兄弟们看我操作");
    }

    public void select(){
        System.out.println("随便选, 我乱杀");
    }

    @Override
    public void play() {
        player.play();
    }

    public void end(){
        System.out.println("这就是大气层 夫赖");
    }
}
