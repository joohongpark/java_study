
public class mainClass {

	public static void main(String[] args) {
		// 선언 - 배열변수 intArr을 선언하며 메모리에 intArr라고 할당된 부분은 정수형 배열의 위치를 저장하는 공간을 의미한다. 해당 변수는 힙 영역에 저장된다.
		int[] intArr;
		byte[][] multiArr; // 다차원 배열도 선언 가능하다.
		int[] ref;

		// 초기화 - 실제 스택 영역에 저장되는 정수형 배열의 크기와 메모리 위치를 동적으로 할당한다.
		intArr = new int[2];
		multiArr = new byte[2][2];
		ref = intArr;

		// 접근 - 대괄호 연산자의 인덱스를 이용하여 배열 메모리에 접근한다.
		intArr[0] = 10;
		intArr[1] = 20;
		System.out.println(intArr[0] + ", " + intArr[1]);
		System.out.println(ref[0] + ", " + ref[1]);

		multiArr[0][0] = 0;
		multiArr[0][1] = 1;
		multiArr[1][0] = 2;
		multiArr[1][1] = 3;
		System.out.printf("%d %d %d %d",
		                 multiArr[0][0],
		                 multiArr[0][1],
		                 multiArr[1][0],
		                 multiArr[1][1]);
	}

}
