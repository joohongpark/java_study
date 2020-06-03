package main;

import cls.cc.*;

public class mainClass {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		test t = new test(); // PROTECTED KEYWORD TEST
		p.func();
		c.func();
		t.func();
		
		/* 객체의 업캐스팅 */
		Parent u = c;
		u.func(); // 자식클래스가 부모클래스처럼 동작됨. 하지만 오버라이딩된 내용은 그대로 가져간다.
		
		/* 객체의 다운캐스팅 */
		((Child)u).func(); // 다시 자식클래스 속성을 가지고 동작함
	}

}

class test extends Parent {
	public void func() {
		System.out.println(proVal);
	}
}