import java.util.Scanner;

public class HW13_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long sum = 0;
		double average = 0.0;
		int arrayDynamicAssignSize;
		int[] numArr;
		System.out.println("연산하고 싶은 숫자의 개수를 입력 >> ");
		arrayDynamicAssignSize = scan.nextInt();
		numArr = new int[arrayDynamicAssignSize];
		System.out.println("개수에 맞게 숫자를 입력 받음 >> ");
		for (int i = 0; i < arrayDynamicAssignSize; i++) {
			numArr[i] = scan.nextInt();
		}
		for (int i = 0; i < arrayDynamicAssignSize; i++) {
			sum += numArr[i];
		}
		average = (float)sum / arrayDynamicAssignSize;
		System.out.printf("합계 : %d, 평균 : %f", sum, average);
		scan.close();
	}

}
