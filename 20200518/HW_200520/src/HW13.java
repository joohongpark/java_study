public class HW13 {
	public static void main(String[] args) {
		int rand;
		System.out.println("����: 0 ~ 99 ����: 1��");
		rand = (int) (Math.random() * 100);
		System.out.println("�� : " + rand);
		System.out.println("����: 11, 12, 13, 14, 15 ����: 1��");
		rand = (int) (Math.random() * 6) + 10;
		System.out.println("�� : " + rand);
		System.out.println("����: 1 ~ 45 ����: 6��");
		for(int i = 0; i < 6; i++) {
			rand = (int) (Math.random() * 46);
			System.out.println("�� : " + rand);
		}
	}
}
