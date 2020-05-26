package work5;

public class mainClass {
	public static final int SIZE = 4;
	public static final int RANGE = 52;
	public static void main(String[] args) {
		int rand[] = new int[SIZE];
		boolean check[] = new boolean[RANGE];
		// 1. 4���� ���� �ٸ� ���� ����
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
		// 2. ���� ī�� ��ȣ ���
		
		for(int i : rand) {
			int cardClass = i / 13;
			int cardNumber = i % 13;
			switch(cardClass) {
			case 0:
				System.out.printf("%d\t�����̵�\t%d\n", i, cardNumber);
				break;
			case 1:
				System.out.printf("%d\t���̾�\t%d\n", i, cardNumber);
				break;
			case 2:
				System.out.printf("%d\tŬ�ι�\t%d\n", i, cardNumber);
				break;
			case 3:
				System.out.printf("%d\t��Ʈ\t%d\n", i, cardNumber);
				break;
			default:
				break;
			}
		}
		
		// Ʈ���� ī�� A 2 3 4 5 ... 10 J Q K * 4
		// 0 ~ 51 ����
		// 0 ~ 12 -> (0���� ����
	}
}
