
public class mainClass {

	public static void main(String[] args) {
		byte oneByte = 0x7f;
		int oneInteger = 0x7fffffff;
		long oneLong = 0x7fffffffffffffffL; // ���ͷ� ���λ�  L �ٿ�����.
		char onechar = '��';
		oneByte = (byte) (oneByte + 1); // overflow �߻� -> -128
		System.out.println(oneByte);
		System.out.println(oneInteger);
		System.out.println(oneLong);
		System.out.println(onechar);

	}

}
