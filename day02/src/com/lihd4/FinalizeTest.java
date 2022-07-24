package com.lihd4;

/**
 * 子类重写此方法, 可以在对象被释放前进行某些操作
 */
public class FinalizeTest {
	//反复运行结果是不同的, 通知垃圾回收器挥手并不会立马回收
	//可能是有多个线程一起在执行这个
	public static void main(String[] args) {
		Person p = new Person("Peter", 12);
		System.out.println(p);
		p = null;//此时对象实体就是垃圾对象，等待被回收。但时间不确定。
		System.gc();//强制性释放空间

		System.out.println("-----------------------------");
		Person a = new Person("钟离",9000);
		System.out.println(a);
		a = null;
		System.gc();
		System.out.println("钟离还在吗 ? " + a);//不会报错 但是输出顺序很奇怪
	}
}

class Person{
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//子类重写此方法，可在释放对象前进行某些操作
	@Override
	protected void finalize() throws Throwable {

		System.out.println();

		System.out.println("对象被释放--->" + this);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

