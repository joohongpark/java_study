package Exercise;

public class Exercise4 {

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
	}
	public static boolean isNumber(String str) {
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
