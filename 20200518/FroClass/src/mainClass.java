
public class mainClass {

	public static void main(String[] args) {
		int j;
		int[] iarr = new int[10];
		
		for (int i = 0; i < 3; i++) {
			System.out.println("배가 고프다");
		}
		
		for (j = 0; j < 10; j++) {
			System.out.println("j : " + j);
			iarr[j] = j * 10;
		}
		
		for (int k = 0; k < iarr.length; k++) {
			System.out.printf("iarr[%d] : %d\n", k, iarr[k]);
		}
		
		for (int iter : iarr) {
			System.out.println(iter);
		}
		
		//System.out.printf("i : %d, j : %d", i, j); i는 for문 loop scope 내에서 정의된것이기 때문에 에러발생. 
	}

}
