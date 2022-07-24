package com.lihd1;

/**
 * 模板设计方法 求定积分
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 10:43
 */
public class TemplateTest {

    public static void main(String[] args) {
        Area a = new Area() {
            @Override
            public double code(double x) {
                return 4 - x*x;
            }
        };

        Area b = new Area() {
            @Override
            public double code(double x) {
                return Math.sin(x);
            }
        };


        System.out.println(a.getArea(-2,2));
        System.out.println(b.getArea(0,Math.PI));
    }

}

abstract class Area{

    private final double precision;

    public Area(){
        precision = 1e-5;
    }

    public Area(double precision){
        this.precision = precision;
    }

    public abstract double code(double x);

    public double getArea(double a, double b){
        //1 切分成 n 份
        int n = (int) ((b - a)/precision);
        double area = 0;
        for (int i = 1; i <= n; i++) {
            //横坐标

            double c = a + precision * i;


            //纵坐标
            double h = code(c);
            //System.out.println(h);


            //面积 = h * precison
            //累计面积 如下
            area += h * precision;

        }

        return area;
    }


}