import java.util.Scanner;

public class HW17 {

	public static void main(String[] args) {
		int oddSum = 0;
		int evenSum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1)  oddSum += i;
			else			evenSum += i;
		}
		System.out.println("1���� 100 ���� ¦���� ���� : " + evenSum);
		System.out.println("1���� 100 ���� Ȧ���� ���� : " + oddSum);
	}

}
