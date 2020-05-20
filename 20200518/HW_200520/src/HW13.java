public class HW13 {
	public static void main(String[] args) {
		int rand;
		System.out.println("범위: 0 ~ 99 개수: 1개");
		rand = (int) (Math.random() * 100);
		System.out.println("값 : " + rand);
		System.out.println("범위: 11, 12, 13, 14, 15 개수: 1개");
		rand = (int) (Math.random() * 6) + 10;
		System.out.println("값 : " + rand);
		System.out.println("범위: 1 ~ 45 개수: 6개");
		for(int i = 0; i < 6; i++) {
			rand = (int) (Math.random() * 46);
			System.out.println("값 : " + rand);
		}
	}
}
