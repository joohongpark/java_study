package work7;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		int studentNumber;
		double averageKoreanScore = 0;
		double averageMathScore = 0;
		double averageEnglishScore = 0;
		int maxKoreanScore = 0;
		int maxMathScore = 0;
		int maxEnglishScore = 0;
		int minKoreanScore = 100;
		int minMathScore = 100;
		int minEnglishScore = 100;
		int[] minMaxIndex[] = new int[2][3];
		int [] studentScore[];
		String[] studentName;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�Է��� �л� ���� ���� �Է��ϼ��� >> ");
		studentNumber = scan.nextInt();
		
		// ���� �Ҵ�
		studentName = new String[studentNumber];
		studentScore = new int[studentNumber][3];
		
		for (int iter = 0; iter < studentNumber; iter++) {
			System.out.printf("(%d/%d) �л� �̸�, ����, ����, ���� ������ ���� �������� ���ʷ� �Է��ϼ��� >> ", iter + 1, studentNumber);
			studentName[iter] = scan.next();
			for (int classNumber = 0; classNumber < 3; classNumber++) {
				studentScore[iter][classNumber] = scan.nextInt();
				/*
				if(0 > studentScore[iter][i] || studentScore[iter][i] > 100) {
					System.out.println("������ �ùٸ� ���� (0~100) ������ �Է��ϼ���");
					i--;
				}
				*/
			}
		}
		
		for (int iter = 0; iter < studentNumber; iter++) {
			//1. ����
			averageKoreanScore += studentScore[iter][0];
			if(studentScore[iter][0] >= maxKoreanScore) {
				maxKoreanScore = studentScore[iter][0];
				minMaxIndex[0][0] = iter;
			}
			if(studentScore[iter][0] <= minKoreanScore) {
				minKoreanScore = studentScore[iter][0];
				minMaxIndex[1][0] = iter;
			}

			//2. ����
			averageEnglishScore += studentScore[iter][1];
			if(studentScore[iter][1] >= maxEnglishScore) {
				maxEnglishScore = studentScore[iter][1];
				minMaxIndex[0][1] = iter;
			}
			if(studentScore[iter][1] <= minEnglishScore) {
				minEnglishScore = studentScore[iter][1];
				minMaxIndex[1][1] = iter;
			}
			
			//3. ����
			averageMathScore += studentScore[iter][2];
			if(studentScore[iter][2] >= maxMathScore) {
				maxMathScore = studentScore[iter][2];
				minMaxIndex[0][2] = iter;
			}
			if(studentScore[iter][2] <= minMathScore) {
				minMathScore = studentScore[iter][2];
				minMaxIndex[1][2] = iter;
			}
		}

		averageKoreanScore /= studentNumber;
		averageEnglishScore /= studentNumber;
		averageMathScore /= studentNumber;

		System.out.printf("������ ��հ� : %.02f %.02f %.02f\n", averageKoreanScore, averageEnglishScore, averageMathScore);
		System.out.printf("������ �ִ밪 : %d(%s) %d(%s) %d(%s)\n",
				maxKoreanScore, studentName[minMaxIndex[0][0]],
				maxEnglishScore, studentName[minMaxIndex[0][1]],
				maxMathScore, studentName[minMaxIndex[0][2]]);
		System.out.printf("������ �ּҰ� : %d(%s) %d(%s) %d(%s)\n",
				minKoreanScore, studentName[minMaxIndex[1][0]],
				minEnglishScore, studentName[minMaxIndex[1][1]],
				minMathScore, studentName[minMaxIndex[1][2]]);
		scan.close();
	}

}
