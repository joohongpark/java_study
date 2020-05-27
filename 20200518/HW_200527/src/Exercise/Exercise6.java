package Exercise;

public class Exercise6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("한글asdf12rqw");
		System.out.println(enc("한글asdf12rqw"));
		System.out.println(encdec("한글asdf12rqw", true));
		System.out.println(encdec("한글`]@$we[|:", false));
	}
	public static String enc(String str) {
		char[] abcCode ={'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		char[] charArray = new char[str.length()];
		for (int index = 0; index < str.length(); index++) {
			if( ('a' <= str.charAt(index)) && ('z' >= str.charAt(index)) ) {
				charArray[index] = abcCode[str.charAt(index) - 'a'];
			} else if ( ('0' <= str.charAt(index)) && ('9' >= str.charAt(index)) ) {
				charArray[index] = numCode[str.charAt(index) - '0'];
			} else {
				charArray[index] = str.charAt(index);
			}
		}
		return new String(charArray);
	}
	public static String encdec(String str, boolean isEncode) {
		char[] dict[] = {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'},
				{'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/','q','w','e','r','t','y','u','i','o','p'}};
		char[] charArray = new char[str.length()];
		boolean checked = false;
		for (int index = 0; index < str.length(); index++) {
			checked = false;
			for (int i = 0; i < dict[0].length; i++) {
				if(str.charAt(index) == dict[isEncode ? 0 : 1][i]) {
					charArray[index] = dict[isEncode ? 1 : 0][i];
					checked = true;
					break;
				}
			}
			if(checked == false) {
				charArray[index] = str.charAt(index);
			}
		}
		return new String(charArray);
	}
}
