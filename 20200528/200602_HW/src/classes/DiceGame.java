package classes;

import java.util.Scanner;

public class DiceGame {
	final private int d1, d2;
	
	public DiceGame() {
		int tmp1, tmp2;
		do {
			tmp1 = (int) (Math.random() * 6) + 1;
			tmp2 = (int) (Math.random() * 6) + 1;
		} while(tmp1 != tmp2);
		d1 = tmp1;
		d2 = tmp2;
	}
	
	public int dividend(int number) {
		int returnvalue = 0;
		if(number == 3 || number == 11) returnvalue = 18;
		else if(number == 4 || number == 10) returnvalue = 12;
		else if(number == 5 || number == 9) returnvalue = 9;
		else if(number == 6 || number == 8) returnvalue = 7;
		else if(number == 7) returnvalue = 6;
		else returnvalue = 0;
		return returnvalue;
	}
	
	public void start() {
		int coin, sum;
		Scanner scan = new Scanner(System.in);
		System.out.println("배팅할 코인 수는? -> ");
		coin = getNumber(scan);
		System.out.println("두 주사위의 합은? -> ");
		sum = getNumber(scan);
		System.out.printf("실제 주사위 값 : %d, 배당금 : %d\n", d1+d2, dividend(d1+d2) * coin);
		scan.close();
	}
	
    static int getNumber(Scanner scan) {
        boolean isNumber = false;
        String str = "";
        while(!isNumber) {
            str = scan.next();
            isNumber = isNumber(str);
            if(!isNumber) {
                System.out.println("[error] 올바른 숫자를 입력해 주세요!");
            }
        }
        return Integer.parseInt(str);
    }
    
    static boolean isNumber(String str) {
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if( ('0' > str.charAt(i)) || ('9') < str.charAt(i) ) {
                result = false;
                break;
            }
        }
        return result;
    }
}
