package main;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		singleton2.getArray(); 

	}

}
