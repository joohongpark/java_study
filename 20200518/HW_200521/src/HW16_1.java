import java.util.Scanner;

public class HW16_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y, result;
		char op;
		System.out.println("첫 번째 수 >> ");
		x = scan.nextInt();
		System.out.println("연산자 >> ");
		op = scan.next().charAt(0);
		System.out.println("두 번째 수 >> ");
		y = scan.nextInt();
		switch (op) {
		case '+':
			result = x + y;
			break;
		case '-':
			result = x - y;
			break;
		case '*':
			result = x * y;
			break;
		case '/':
			result = x / y;
			break;
		case '%':
			result = x % y;
			break;
		default:
			result = 0;
			break;
		}
		System.out.printf("%d %c %d = %d\n", x, op, y, result);
		scan.close();
	}

}
