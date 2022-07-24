package com.lihd2;

/**
 * 接口的实际应用
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 15:07
 */
public class AnonymousTest {
    public static void main(String[] args) {

        //非匿名接口 非匿名对象
        Squ s1 = new Squ();

        double area1 = new Calu(s1).getArea(1,2);
        System.out.println(area1);

        //非匿名接口 匿名对象

        double area2 = new Calu(new Squ()).getArea(0,1);
        System.out.println(area2);

        //匿名接口 非匿名
        Func x = new Func() {
            @Override
            public double f(double x) {
                return x;
            }
        };

        double area3 = new Calu(x).getArea(0,1);

        System.out.println(area3);

        //匿名类匿名接口

        double area4 = new Calu(new Func() {
            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        }).getArea(0, Math.PI);

        System.out.println(area4);


        //lambda
        System.out.println(new Calu(a -> a * a * a).getArea(1, 1));

        //更高级点
        System.out.println(new Calu(Math::cos).getArea(0,1));



    }

}


class Calu{

    private Func func;

    private final double precision = 1e-5;

    public Calu(Func func){
        this.func = func;
    }

    public double getArea(double a, double b){
        int n = (int) ((b - a)/precision);
        double area = 0;
        for (int i = 1; i <= n; i++) {
            double c = a + precision * i;
            double h = func.f(c);
            area += h * precision;
        }
        return area;
    }
}

class Squ implements Func{
    @Override
    public double f(double x) {
        return x*x;
    }
}

interface Func{
    double f(double x);
}