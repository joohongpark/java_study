import java.util.Scanner;

public class HW12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i;
		System.out.print("�� �Է� : ");
		i = scan.nextInt();
		// ���� �Է�

		// �Ǵ�, ���
		if(i == 0) {
			System.out.println("0�Դϴ�");
		} else {
			System.out.println((i > 0) ? "����Դϴ�" : "�����Դϴ�");
		}
	}

}
