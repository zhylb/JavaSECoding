package com.lihd4;
//Object类的clone()的使用
public class CloneTest {
	public static void main(String[] args) {
		Animal a1 = new Animal("花花");
		try {
			Animal a2 = (Animal) a1.clone();
			System.out.println("原始对象：" + a1);
			a2.setName("毛毛");
			System.out.println("clone之后的对象：" + a2);
			System.out.println(a1 == a2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


		System.out.println("----------------------\n自己编写一遍");
		Animal a = new Animal("狗子");
		try{

			Animal b  = (Animal) a.clone();
			System.out.println(b == a);
			b.setName("恶犬");

			System.out.println(a);
			System.out.println(b);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


	}
}

class Animal implements Cloneable{
	private String name;

	public Animal() {
		super();
	}

	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}