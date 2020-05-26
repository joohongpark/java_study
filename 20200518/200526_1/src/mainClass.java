
public class mainClass {

	public static void main(String[] args) {
		//1
		int arrTwoDiv[][] = {
				{1,2,3},
				{4,5,6},
				{4,5,6}
		};
		int arrOneDiv[] = new int[arrTwoDiv.length * arrTwoDiv[0].length];
		int iter = 0;
		for(int arr1[] : arrTwoDiv) {
			for(int arr2 : arr1) {
				arrOneDiv[iter++] = arr2;
			}
		}
		for(int re : arrOneDiv) {
			System.out.print(re + " ");
		}
		
		System.out.println();

		//2
		int[] fib = new int[3];
		fib[0] = 0;
		fib[1] = 1;
		int repeat = 20;
		for (int i = 0; i < repeat; i++) {
			fib[(i + 2) % 3] = fib[(i + 3) % 3] + fib[(i + 1) % 3];
			System.out.print(fib[i % 3] + " ");
		}
	}

}
