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
		
		System.out.print("입력할 학생 수를 먼저 입력하세요 >> ");
		studentNumber = scan.nextInt();
		
		// 동적 할당
		studentName = new String[studentNumber];
		studentScore = new int[studentNumber][3];
		
		for (int iter = 0; iter < studentNumber; iter++) {
			System.out.printf("(%d/%d) 학생 이름, 국어, 영어, 수학 성적을 엔터 기준으로 차례로 입력하세요 >> ", iter + 1, studentNumber);
			studentName[iter] = scan.next();
			for (int classNumber = 0; classNumber < 3; classNumber++) {
				studentScore[iter][classNumber] = scan.nextInt();
				/*
				if(0 > studentScore[iter][i] || studentScore[iter][i] > 100) {
					System.out.println("점수를 올바른 범위 (0~100) 내에서 입력하세요");
					i--;
				}
				*/
			}
		}
		
		for (int iter = 0; iter < studentNumber; iter++) {
			//1. 국어
			averageKoreanScore += studentScore[iter][0];
			if(studentScore[iter][0] >= maxKoreanScore) {
				maxKoreanScore = studentScore[iter][0];
				minMaxIndex[0][0] = iter;
			}
			if(studentScore[iter][0] <= minKoreanScore) {
				minKoreanScore = studentScore[iter][0];
				minMaxIndex[1][0] = iter;
			}

			//2. 영어
			averageEnglishScore += studentScore[iter][1];
			if(studentScore[iter][1] >= maxEnglishScore) {
				maxEnglishScore = studentScore[iter][1];
				minMaxIndex[0][1] = iter;
			}
			if(studentScore[iter][1] <= minEnglishScore) {
				minEnglishScore = studentScore[iter][1];
				minMaxIndex[1][1] = iter;
			}
			
			//3. 수학
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

		System.out.printf("국영수 평균값 : %.02f %.02f %.02f\n", averageKoreanScore, averageEnglishScore, averageMathScore);
		System.out.printf("국영수 최대값 : %d(%s) %d(%s) %d(%s)\n",
				maxKoreanScore, studentName[minMaxIndex[0][0]],
				maxEnglishScore, studentName[minMaxIndex[0][1]],
				maxMathScore, studentName[minMaxIndex[0][2]]);
		System.out.printf("국영수 최소값 : %d(%s) %d(%s) %d(%s)\n",
				minKoreanScore, studentName[minMaxIndex[1][0]],
				minEnglishScore, studentName[minMaxIndex[1][1]],
				minMathScore, studentName[minMaxIndex[1][2]]);
		scan.close();
	}

}
