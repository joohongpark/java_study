package work6;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		boolean isNumber = true;
		boolean isNaturalNumber = true;
		System.out.print("���� �Է� >> ");
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
			System.out.println("���ڷ� �Ǿ� ���� �ʽ��ϴ�.");
		} else {
			System.out.printf("���ڷ� �Ǿ� ������ �ش� ���ڴ� %s�Դϴ�.", isNaturalNumber ? "����" : "�Ǽ�");
		}
		scan.close();
	}

}
