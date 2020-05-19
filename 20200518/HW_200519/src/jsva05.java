import java.util.Scanner;
public class jsva05 {

	public static void main(String[] args) {
		int x, y;
		Scanner scan = new Scanner(System.in);
		System.out.print("x = ");
		x = scan.nextInt();
		System.out.print("y = ");
		y = scan.nextInt();
		
		//swap (temp value)
		//int tmp;
		//tmp = y;
		//y = x;
		//x = tmp;
		//swap (xor swap)
		y ^= x;
		x ^= y;
		y ^= x;
		
		System.out.printf("Ãâ·Â:\nx = %d y = %d", x, y);
	}

}
