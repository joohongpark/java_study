package Exercise;

public class Exercise5 {

	public static void main(String[] args) {
		int[] num1 = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(num1));
		getDouble(num1);
		System.out.println(java.util.Arrays.toString(num1));
	}
	public static void getDouble(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2;
		}
	}
}
