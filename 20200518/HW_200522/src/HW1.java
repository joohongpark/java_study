import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rand = (int) (Math.random() * 100) + 1;
		int input;
		char playContinue = 'y';
		System.out.println("1���� 100������ ���� ���� ���߱�");
		while(playContinue == 'y') {
			for (int i = 0; i < 10; i++) {
				System.out.printf("1���� 100���� ���� �����ϱ��(%d/10) >> ", i + 1);
				input = scan.nextInt();
				if( (input < 1) || (input > 100) ) {
					System.out.println("�������� ������ ���ڸ� �Է����ּ���");
				} else if(rand > input) {
					System.out.printf("%d���� Ů�ϴ�.\n", input);
				} else if(rand < input) {
					System.out.printf("%d���� �۽��ϴ�.\n", input);
				} else {
					playContinue = 'n';
					System.out.println("�����Դϴ�.");
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
