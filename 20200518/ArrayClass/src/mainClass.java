
public class mainClass {

	public static void main(String[] args) {
		// ���� - �迭���� intArr�� �����ϸ� �޸𸮿� intArr��� �Ҵ�� �κ��� ������ �迭�� ��ġ�� �����ϴ� ������ �ǹ��Ѵ�. �ش� ������ �� ������ ����ȴ�.
		int[] intArr;
		byte[][] multiArr; // ������ �迭�� ���� �����ϴ�.
		int[] ref;

		// �ʱ�ȭ - ���� ���� ������ ����Ǵ� ������ �迭�� ũ��� �޸� ��ġ�� �������� �Ҵ��Ѵ�.
		intArr = new int[2];
		multiArr = new byte[2][2];
		ref = intArr;

		// ���� - ���ȣ �������� �ε����� �̿��Ͽ� �迭 �޸𸮿� �����Ѵ�.
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
