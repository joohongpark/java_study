import java.util.Scanner;

public class HW12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i;
		System.out.print("수 입력 : ");
		i = scan.nextInt();
		// 수를 입력

		// 판단, 출력
		if(i == 0) {
			System.out.println("0입니다");
		} else {
			System.out.println((i > 0) ? "양수입니다" : "음수입니다");
		}
	}

}
