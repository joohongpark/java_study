import java.util.Scanner;

public class HW16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.println(">> ");
		num = scan.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d * %d = %d\n", i, num, i*num);
		}
	}

}
