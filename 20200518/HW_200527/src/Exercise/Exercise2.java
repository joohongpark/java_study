package Exercise;

public class Exercise2 {

	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
	public static int[] shuffle(int[] arr) {
		boolean[] checked = new boolean[arr.length];
		// result 할당 안하고 메모리를 아끼면서 시간 면에서 손해가 별로 없는 알고리즘 고려해보기
		int[] result = new int[arr.length];
		int iter = 0;
		while(iter < arr.length) {
			int rand = (int) (Math.random() * arr.length);
			if(checked[rand] == false) {
				result[iter] = arr[rand];
				checked[rand] = true;
				iter++;
			}
		}
		return result;
	}
}
