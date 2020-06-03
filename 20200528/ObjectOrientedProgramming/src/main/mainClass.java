package main;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner scan = new Scanner(System.in);
		BaseBall b = new BaseBall();
		b.game(scan);
		scan.close();
	}

}
