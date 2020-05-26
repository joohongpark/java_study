import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char isAscend;
		int arrSize;
		int[] array;
		System.out.print("오름차순 정렬인가요? (y/n) >> ");
		isAscend = scan.next().charAt(0);

		arrSize = scan.nextInt();
		array = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			System.out.print(">> ");
			array[i] = scan.nextInt();
		}
		SelectionSort(array, (isAscend == 'y'));
		System.out.println();
		for(int i : array) {
			System.out.print(i + " ");
		}

	}
	
	public static void SelectionSort(int[] arr, boolean isAscend) {
		int tmp, idx;
		for (int i = 0; i < arr.length; i++) {
			idx = i;
			for (int j = i; j < arr.length; j++) {
				if( isAscend ? (arr[j] <= arr[idx]) : (arr[j] >= arr[idx])) {
					tmp = arr[j];
					arr[j] = arr[idx];
					arr[idx] = tmp;
				}
			}
		}
	}

}
