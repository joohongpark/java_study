package Exercise;

public class Exercise3 {

	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪:"+max(data));
	}
	public static int max(int[] arr) {
		int max = 0;
		for(int iter : arr) {
			if(iter > max) {
				max = iter;
			}
		}
		return max;
	}
}
