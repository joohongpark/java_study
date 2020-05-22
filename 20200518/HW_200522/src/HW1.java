import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rand = (int) (Math.random() * 100) + 1;
		int input;
		char playContinue = 'y';
		System.out.println("1부터 100까지의 랜덤 숫자 맞추기");
		while(playContinue == 'y') {
			for (int i = 0; i < 10; i++) {
				System.out.printf("1부터 100에서 무슨 숫자일까요(%d/10) >> ", i + 1);
				input = scan.nextInt();
				if( (input < 1) || (input > 100) ) {
					System.out.println("정상적인 범위의 숫자를 입력해주세요");
				} else if(rand > input) {
					System.out.printf("%d보다 큽니다.\n", input);
				} else if(rand < input) {
					System.out.printf("%d보다 작습니다.\n", input);
				} else {
					playContinue = 'n';
					System.out.println("정답입니다.");
					break;
				}
			}
			if(playContinue == 'y') {
				System.out.println("기회 10번이 모두 끝났는데 계속 하시겠습니까? (y/n) >>");
				playContinue = scan.next().charAt(0);
				if(playContinue != 'y') {
					break;
				}
			}
		}
		scan.close();
	}

}
