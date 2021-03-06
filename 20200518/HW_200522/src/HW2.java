import java.util.Scanner;

public class HW2 {
/*
		String str = "10 11 1234";
		int start = 0;
		int cnt = 0;
		boolean check = false;
		char tmp;
		int[] inputArr = new int[3];
        for (int i = 0; i < str.length(); i++) {
            tmp = str.charAt(i);
            if( (tmp >= '0') && (tmp <= '9') ) {
                if(check == false) {
                    start = i;
                }
                check = true;
                System.out.println("is num - " + tmp);
                if( (i > start) && (i == str.length() - 1) ) {
                    inputArr[cnt] = Integer.parseInt(str.substring(start, i + 1));
                    cnt++;
                    if(cnt == 3) {
                        break;
                    }
                }
            } else {
                check = false;
                System.out.println("is NOT num");
                if(i > start) {
                    inputArr[cnt] = Integer.parseInt(str.substring(start, i));
                    cnt++;
                    if(cnt == 3) {
                        break;
                    }
                }
            }
        }
        for(int i : inputArr) {
            System.out.println(i);
        }
 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rand[] = new int[3];
		int input[] = new int[3];
		int b, s;
		char playContinue = 'y';
		
		// 1. 3개의 서로 다른 변수 생성
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
					if( (input[iter] == rand[iter])) {
						s++;
					}
				}
				// ball 탐색
				for(int inputIter = 0; inputIter < 3; inputIter++) {
					for(int randomIter = 0; randomIter < 3; randomIter++) {
						if( (input[inputIter] == rand[randomIter])) {
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
		scan.close();
	}

}
