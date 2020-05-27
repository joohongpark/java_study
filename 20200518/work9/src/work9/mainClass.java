package work9;

public class mainClass {

	public static void main(String[] args) {
		// 몫과 나머지 구할수있는 함수
		int[] result1;
		result1 = div(10,3);
		System.out.println(result1[0]);
		System.out.println(result1[1]);
		System.out.println(toUpperCase("1q2w3e4rS3fa3qefwef"));

	}
	public static int[] div(int a, int b) {
		int[] array = new int[2];
		array[0] = a/b;
		array[1] = a%b;
		return array;
	}
	public static String toUpperCase(String str) {
		char[] returnStr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if( (str.charAt(i) >= 'a') && (str.charAt(i) <= 'z') ) {
				returnStr[i] = (char) (str.charAt(i) - 'a' + 'A');
			} else {
				returnStr[i] = str.charAt(i);
			}
		}
		return new String(returnStr);
	}

}
