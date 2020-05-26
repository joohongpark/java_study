import java.util.Scanner;

public class mainClass {
	/*
	 * 숫자 입력 -> 메뉴 번호
	 * 1. 10 to 2
	 * 2. 2 to 10
	 * 3. 10 to 16
	 * 4. 16 to 10
	 * 5. 2 to 16
	 * 6. 16 to 2
	 * 7. exit
	 */
	public static void main(String[] args) {
		int s;
		int number;
		boolean loopContinue = true;
		Scanner scan = new Scanner(System.in);
		while(loopContinue) {
			menu();
			System.out.print("숫자를 입력하세요 >> ");
			s = scan.nextInt();
			System.out.print("변환할 숫자를 입력하세요 >> ");
			switch(s) {
			case 1:
				number = scan.nextInt(10);
				System.out.printf("%d => 0b%s\n", number, Integer.toBinaryString(number));
			break;
			case 2:
				number = scan.nextInt(2);
				System.out.printf("0b%s => %d\n", Integer.toBinaryString(number), number);
			break;
			case 3:
				number = scan.nextInt(10);
				System.out.printf("%d => 0x%x\n", number, number);
			break;
			case 4:
				number = scan.nextInt(16);
				System.out.printf("0x%x => %d\n", number, number);
			break;
			case 5:
				number = scan.nextInt(2);
				System.out.printf("0b%s => 0x%x\n", Integer.toBinaryString(number), number);
			break;
			case 6:
				number = scan.nextInt(16);
				System.out.printf("0x%x => 0b%s", number, Integer.toBinaryString(number));
			break;
			default:
				loopContinue = false;
			break;
			}
		}
		scan.close();
	}
	static void menu() {
		System.out.println("1. 10진수를 2진수로");
		System.out.println("2. 2진수를 10진수로");
		System.out.println("3. 10진수를 16진수로");
		System.out.println("4. 16진수를 10진수로");
		System.out.println("5. 2진수를 16진수로");
		System.out.println("6. 16진수를 2진수로");
		System.out.println("7. 종료");
	}
}
