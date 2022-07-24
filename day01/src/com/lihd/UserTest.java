package com.lihd;

/**
 * 局部变量 和 属性
 * 相同点:
 *      1 定义变量的格式 : 类型 名称 = 值
 *      2 先声明 后使用
 *      3 变量都有其对应的作用域
 *
 * 不同点:
 *      1 声明位置不同
 *          局部变量声明于 代码块 构造器形参 构造器方法 方法形参 方法内部
 *          属性直接声明于 类的{}内
 *      2 权限修饰符不同
 *          局部变量 没有权限修饰符
 *          属性可以有 : public 缺省 protected private 四种权限修饰符
 *      3 默认初始化值不同
 *          属性: 根据类型都有其默认初始化值
 *              整形(byte short int long) 0
 *              浮点型(float double) 0.0
 *              字符型(char) 0 \u0000
 *              布尔型(boolean) false
 *
 *              引用数据类型(类 接口 数组) null
 *          局部变量 : 没有初始化值 先声明 , 后使用 使用前一定要赋值
 *              形参在调用时由调用者赋值
 *      4 在内存中加载的位置
 *          属性:加载到堆空间中(非static)
 *          局部变量 : 加载到栈空间中
 *
 *
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/8 20:27
 */
public class UserTest {
    public static void main(String[] args) {

        User u = new User();

        //测试几个默认值
        System.out.println(u.age);//0
        System.out.println(u.name);//null
        System.out.println(u.isMale);//false
    }


}

class User{
    public int age;
    String name;
    boolean isMale;

}
