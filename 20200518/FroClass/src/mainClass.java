
public class mainClass {

	public static void main(String[] args) {
		int j;
		int[] iarr = new int[10];
		
		for (int i = 0; i < 3; i++) {
			System.out.println("�谡 ������");
		}
		
		for (j = 0; j < 10; j++) {
			System.out.println("j : " + j);
			iarr[j] = j * 10;
		}
		
		for (int k = 0; k < iarr.length; k++) {
			System.out.printf("iarr[%d] : %d\n", k, iarr[k]);
		} 
		
		/*
		 * foreach�� ������ for���� �ڹٿ��� ��� �����ϴ�.
		 * for (<�迭 �ڷ���> ���Ҹ� : �迭)
		 * ������ ���� ����� ���� �ݺ������� index�� ������ ���� �ʴ´�.
		 */
		for (int iter : iarr) {
			System.out.println(iter);
		}
		
		//System.out.printf("i : %d, j : %d", i, j); i�� for�� loop scope ������ ���ǵȰ��̱� ������ �����߻�. 
	}

}
