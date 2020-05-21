
public class HW18_1 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < ((i < 6)?(i):(10 - i)); j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
