package main;

import generic.Box;

public class mainClass {

	public static void main(String[] args) {
		System.out.println("123");
		Box b = new Box();
		b.SetT("afdafa");
		System.out.println(b.GetT());
		Box<Integer> i = new Box<Integer>();
		i.SetT(10);
		// 왜 프리미티브 자료형은 들어가지 않는것일까?
		System.out.println(i.GetT());
	}

}
