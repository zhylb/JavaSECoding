package com.lihd;

/*
猜一猜执行的顺序

一个子类创建对象, 需要先把父类加载到内存..., 最后会把Object加入到内存
因此从父类到子类所有的静态代码块会先执行一遍

然后子类创建对象, 由于子类继承了父类的属性和方法, 因此会先加载父类对象
于是父类的非静态代码块也会从上到下执行一遍



"先父后子 静态先行"


 */
class Root{
	static{
		System.out.println("Root的静态初始化块");
	}
	{
		System.out.println("Root的普通初始化块");
	}
	public Root(){
		System.out.println("Root的无参数的构造器");
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid(){
		System.out.println("Mid的无参数的构造器");
	}
	public Mid(String msg){
		//通过this调用同一类中重载的构造器
		this();
		System.out.println("Mid的带参数构造器，其参数值："
			+ msg);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}	
	public Leaf(){
		//通过super调用父类中有一个字符串参数的构造器
		super("尚硅谷");
		System.out.println("Leaf的构造器");
	}
}
public class LeafTest{
	public static void main(String[] args){
		new Leaf();
		System.out.println();
		new Leaf();
	}
}

