
public class HW11 {

	public static void main(String[] args) {
		int num1, num2;
		num1 = 128;
		num2 = 56;
		System.out.printf("num1(before) : 0x%X\n", num1);
		System.out.printf("num2(before) : 0x%X\n", num2);
		num1 = (num1 & num2) | (num1 & num2);
		num2 = ~(num1 ^ num2);
		System.out.printf("num1 : 0x%X\n", num1);
		System.out.printf("num2 : 0x%X\n", num2);
		
	}

}
