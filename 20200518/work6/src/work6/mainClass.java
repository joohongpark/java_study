package work6;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		boolean isNumber = true;
		boolean isNaturalNumber = true;
		System.out.print("숫자 입력 >> ");
		str = scan.next();
		for(int index = 0; index < str.length(); index++) {
			if( (str.charAt(index) < '0') || (str.charAt(index) > '9') ) {
				if( (str.charAt(index) == '.') && (isNaturalNumber == true) ) {
					isNaturalNumber = false;
					break;
				} else {
					isNumber = false;
				}
			}
		}
		if(isNumber != true) {
			System.out.println("숫자로 되어 있지 않습니다.");
		} else {
			System.out.printf("숫자로 되어 있으며 해당 숫자는 %s입니다.", isNaturalNumber ? "정수" : "실수");
		}
		scan.close();
	}

}
