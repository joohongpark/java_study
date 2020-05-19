
public class mainClass {

	public static void main(String[] args) {
		byte oneByte = 0x7f;
		int oneInteger = 0x7fffffff;
		long oneLong = 0x7fffffffffffffffL; // 리터럴 접두사  L 붙여야함.
		char onechar = '한';
		oneByte = (byte) (oneByte + 1); // overflow 발생 -> -128
		System.out.println(oneByte);
		System.out.println(oneInteger);
		System.out.println(oneLong);
		System.out.println(onechar);

	}

}
