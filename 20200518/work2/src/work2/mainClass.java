package work2;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * ������
		 * �����ؾ� �� �ݾ� : 4230��
		 * �ڽ��� �ݾ� : 10000��
		 * �Ž��� ���� �� ��
		 * 5000, 1000, 500, 100, 50, 10���� ���� ��ΰ�
		 */
		Scanner scan = new Scanner(System.in);
		int bill;
		int account;
		int changes;
		System.out.print("�����ؾ� �� �ݾ� : ");
		bill = scan.nextInt();
		System.out.print("�ڽ��� �ݾ� : ");
		account = scan.nextInt();
		changes = account - bill;
		

		System.out.println("�Ž��� �� : " + changes);
		System.out.println("5000�� : " + changes / 5000 + "��");
		changes %= 5000;
		System.out.println("1000�� : " + changes / 1000 + "��");
		changes %= 1000;
		System.out.println("500�� : " + changes / 500 + "��");
		changes %= 500;
		System.out.println("100�� : " + changes / 100 + "��");
		changes %= 100;
		System.out.println("50�� : " + changes / 50 + "��");
		changes %= 50;
		System.out.println("10�� : " + changes / 10 + "��");
		changes %= 10;
		
		recursive(123450, 10000);
	}
	/* ����Լ��� ���� */
	public static void recursive(int charge, int unit) {
		int c;
		System.out.println(unit + "�� : " + charge / unit + "��(��)");
		c = charge % unit;
		if(c != 0) {
			recursive(c, unit / 10);
		}
	}
}
