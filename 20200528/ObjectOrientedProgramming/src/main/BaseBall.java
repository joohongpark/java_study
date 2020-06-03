package main;

import java.util.Scanner;

public class BaseBall {
	int[] random = new int[3];
	public BaseBall() {
		// 1. 3개의 서로 다른 변수 생성
		for (int i = 0; i < 3; i++) {
			random[i] = (int) (Math.random() * 10) + 1;
			for (int j = 0; j < i; j++) {
				if( (random[i] == random[j]) && (i != 0) ) {
					i--;
				}
			}
		}
	}
	public void game(Scanner scan) {
		int input[] = new int[3];
		int b, s;
		char playContinue = 'y';
		// 2. 게임 시작
		while(playContinue == 'y') {
			for (int i = 0; i < 10; i++) {
				b = s = 0;
				System.out.printf("숫자 세 개를 입력해 주세요(%d/10) >> ", i + 1);
				// 수신 문자열 파싱
				input[0] = scan.nextInt();
				input[1] = scan.nextInt();
				input[2] = scan.nextInt();
				
				// strike 탐색
				for(int iter = 0; iter < 3; iter++) {
					if( (input[iter] == random[iter])) {
						s++;
					}
				}
				// ball 탐색
				for(int inputIter = 0; inputIter < 3; inputIter++) {
					for(int randomIter = 0; randomIter < 3; randomIter++) {
						if( (input[inputIter] == random[randomIter])) {
							b++;
						}
					}
				}
				System.out.printf("B : %d, S : %d\n", b, s);
				if(s == 3) {
					System.out.println("게임에서 우승하였습니다.");
					playContinue = 'n';
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
	}
}
