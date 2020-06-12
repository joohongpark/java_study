package main;

import animal.Animal;
import factory.AnimalFactory;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal d = AnimalFactory.create("개");
		Animal c = AnimalFactory.create("고양이");
		d.say();
		c.say();
	}

}
