import java.util.Scanner;

public class HW14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.println(">> ");
		num = scan.nextInt();
		System.out.printf("�Է��� ���� %d���� ũ�� %d���� �۴�.", 10 * (num / 10), 10 * (num / 10 + 1));
	}

}
