import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rand[] = new int[3];
		int input[] = new int[3];
		int b, s;
		char playContinue = 'y';
		
		// 1. 3���� ���� �ٸ� ���� ����
		for (int i = 0; i < 3; i++) {
			rand[i] = (int) (Math.random() * 10) + 1;
			for (int j = 0; j < i; j++) {
				if( (rand[i] == rand[j]) && (i != 0) ) {
					i--;
				}
			}
		}
		for(int i : rand) {
			System.out.println(i + " ");
		}
		
		// 2. ���� ����
		while(playContinue == 'y') {
			for (int i = 0; i < 10; i++) {
				b = s = 0;
				System.out.printf("���� �� ���� �Է��� �ּ���(%d/10) >> ", i + 1);
				input[0] = scan.nextInt();
				input[1] = scan.nextInt();
				input[2] = scan.nextInt();
				scan.
				// strike Ž��
				for(int iter = 0; iter < 3; iter++) {
					if( (input[iter] == rand[iter])) {
						s++;
					}
				}
				// ball Ž��
				for(int inputIter = 0; inputIter < 3; inputIter++) {
					for(int randomIter = 0; randomIter < 3; randomIter++) {
						if( (input[inputIter] == rand[randomIter])) {
							b++;
						}
					}
				}
				System.out.printf("B : %d, S : %d\n", b, s);
				if(s == 3) {
					System.out.println("���ӿ��� ����Ͽ����ϴ�.");
					playContinue = 'n';
					break;
				}
			}
			if(playContinue == 'y') {
				System.out.println("��ȸ 10���� ��� �����µ� ��� �Ͻðڽ��ϱ�? (y/n) >>");
				playContinue = scan.next().charAt(0);
				if(playContinue != 'y') {
					break;
				}
			}
		}
		scan.close();
	}

}
