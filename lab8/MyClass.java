package lesson8.labs;

import java.util.function.Predicate;

public class MyClass {
	int x;
	String y;

	public MyClass(int x, String y) {
		this.x = x;
		this.y = y;
	}

	// testing method to check the equality using Lambda and Method reference
	public void myMethod(MyClass cl) {
		Predicate<MyClass> p = (c) -> c.equals(this);
		Predicate<MyClass> p1 = this::equals;
		System.out.printf("Using Lambda : " + p.test(cl));
		System.out.println("Using Method Reference : " + p1.test(cl) + "\n");
		
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != getClass())
			return false;
		MyClass mc = (MyClass) ob;
		return mc.x == x && mc.y.equals(y);
	}

	public static void main(String[] args) {
		MyClass myclass = new MyClass(1, "A");
		MyClass myclass1 = new MyClass(1, "B");
		myclass.myMethod(myclass); // print true
		myclass.myMethod(myclass1); // print false
	}
}