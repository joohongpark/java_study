package work2;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * 편의점
		 * 지불해야 할 금액 : 4230원
		 * 자신의 금액 : 10000원
		 * 거스름 돈을 줄 때
		 * 5000, 1000, 500, 100, 50, 10원이 각각 몇개인가
		 */
		Scanner scan = new Scanner(System.in);
		int bill;
		int account;
		int changes;
		System.out.print("지불해야 할 금액 : ");
		bill = scan.nextInt();
		System.out.print("자신의 금액 : ");
		account = scan.nextInt();
		changes = account - bill;
		

		System.out.println("거스름 돈 : " + changes);
		System.out.println("5000원 : " + changes / 5000 + "장");
		changes %= 5000;
		System.out.println("1000원 : " + changes / 1000 + "장");
		changes %= 1000;
		System.out.println("500원 : " + changes / 500 + "개");
		changes %= 500;
		System.out.println("100원 : " + changes / 100 + "개");
		changes %= 100;
		System.out.println("50원 : " + changes / 50 + "개");
		changes %= 50;
		System.out.println("10원 : " + changes / 10 + "개");
		changes %= 10;
		
		recursive(123450, 10000);
	}
	/* 재귀함수로 구현 */
	public static void recursive(int charge, int unit) {
		int c;
		System.out.println(unit + "원 : " + charge / unit + "장(개)");
		c = charge % unit;
		if(c != 0) {
			recursive(c, unit / 10);
		}
	}
}
