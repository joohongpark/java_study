package main;

import AbstractClassTest.RegularPolygon;
import AbstractClassTest.lambdaInterface;
import AbstractClassTest.printAll;
import InterfaceTest.circle;
import InterfaceTest.circleCalc;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square s = new Square(90, 180);
		System.out.println(s.area());
		RegularPolygon triangle = new RegularPolygon(45, 20) {
			@Override
			public double area() {
				return (sideLength * sideLength) * (Math.sqrt(3) / 4);
			}
		};
		System.out.println(triangle.area());
		circle c = new circle() {
			@Override
			public double area(int r) {
				return r*r*circle.PI;
			}
		};
		printAll p = x -> {
			System.out.println(x);
			System.out.println(x);
		};
		p.p("테스트");

		System.out.println(c.area(10));
		lambdaInterface l = () -> {System.out.println("lambda test");};
		l.func();
	}

}
class Square extends RegularPolygon {
	Square(int angle, int sideLength) {
		super(angle, sideLength);
	}
	@Override
	public double area() {
		return sideLength * sideLength;
	}
}