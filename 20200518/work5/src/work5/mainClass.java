package work5;

public class mainClass {
	public static final int SIZE = 4;
	public static final int RANGE = 52;
	public static void main(String[] args) {
		int rand[] = new int[SIZE];
		boolean check[] = new boolean[RANGE];
		// 1. 4개의 서로 다른 변수 생성
		for (int i = 0; i < RANGE; i++) {
			check[i] = false;
		}
		for (int i = 0; i < SIZE; i++) {
			rand[i] = (int) (Math.random() * RANGE);
			if(check[rand[i]] == true) {
				i--;
			} else {
				check[rand[i]] = true;
			}
		}
		// 2. 실제 카드 번호 출력
		
		for(int i : rand) {
			int cardClass = i / 13;
			int cardNumber = i % 13;
			switch(cardClass) {
			case 0:
				System.out.printf("%d\t스페이드\t%d\n", i, cardNumber);
				break;
			case 1:
				System.out.printf("%d\t다이아\t%d\n", i, cardNumber);
				break;
			case 2:
				System.out.printf("%d\t클로버\t%d\n", i, cardNumber);
				break;
			case 3:
				System.out.printf("%d\t하트\t%d\n", i, cardNumber);
				break;
			default:
				break;
			}
		}
		
		// 트럼프 카드 A 2 3 4 5 ... 10 J Q K * 4
		// 0 ~ 51 섞음
		// 0 ~ 12 -> (0부터 시작
	}
}
