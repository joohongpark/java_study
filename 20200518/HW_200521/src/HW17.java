import java.util.Scanner;

public class HW17 {

	public static void main(String[] args) {
		int oddSum = 0;
		int evenSum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1)  oddSum += i;
			else			evenSum += i;
		}
		System.out.println("1부터 100 사이 짝수의 합은 : " + evenSum);
		System.out.println("1부터 100 사이 홀수의 합은 : " + oddSum);
	}

}
