import java.util.Scanner;

public class HW13_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long sum = 0;
		double average = 0.0;
		int arrayDynamicAssignSize;
		int[] numArr;
		System.out.println("�����ϰ� ���� ������ ������ �Է� >> ");
		arrayDynamicAssignSize = scan.nextInt();
		numArr = new int[arrayDynamicAssignSize];
		System.out.println("������ �°� ���ڸ� �Է� ���� >> ");
		for (int i = 0; i < arrayDynamicAssignSize; i++) {
			numArr[i] = scan.nextInt();
		}
		for (int i = 0; i < arrayDynamicAssignSize; i++) {
			sum += numArr[i];
		}
		average = (float)sum / arrayDynamicAssignSize;
		System.out.printf("�հ� : %d, ��� : %f", sum, average);
		scan.close();
	}

}
