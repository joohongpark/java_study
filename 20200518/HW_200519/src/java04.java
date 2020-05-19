import java.util.Scanner;
public class java04 {

	public static void main(String[] args) {
		String bar = "=========================================================";
		String name, man, phone, address;
		int age;
		float height;
		Scanner scan = new Scanner(System.in);
		System.out.print(">>name");
		name = scan.next();
		System.out.print(">>age");
		age = scan.nextInt();
		System.out.print(">>man");
		man = scan.next();
		System.out.print(">>phone");
		phone = scan.next();
		System.out.print(">>height");
		height = scan.nextFloat();
		System.out.print(">>address");
		address = scan.next();
		System.out.println(bar);
		System.out.println("\\ name\tage\tman\tphone\t\theight\taddress\t\\");
		System.out.println(bar);
		System.out.printf("| %s\t%d\t%s\t%s\t%.02f\t%s\t|\n", name, age, man, phone, height, address);
		System.out.println(bar);
	}

}
