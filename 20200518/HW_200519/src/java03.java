public class java03 {
	public static void main(String[] args) {
		String name, man, phone, address;
		int age;
		float height;
		String bar = "=========================================================";
		System.out.println(bar);
		System.out.println("\\ name\tage\tman\tphone\t\theight\taddress\t\\");
		System.out.println(bar);
		name = "홍길동";
		age = 20;
		man = "true";
		phone = "010-111-2222";
		height = 175.12f;
		address = "경기도";
		System.out.printf("| %s\t%d\t%s\t%s\t%.02f\t%s\t|\n", name, age, man, phone, height, address);
		name = "일지매";
		age = 18;
		man = "true";
		phone = "02-123-4567";
		height = 180.01f;
		address = "서울";
		System.out.printf("| %s\t%d\t%s\t%s\t%.02f\t%s\t|\n", name, age, man, phone, height, address);
		name = "장옥정";
		age = 14;
		man = "false";
		phone = "02-345-7890";
		height = 155.78f;
		address = "부산";
		System.out.printf("| %s\t%d\t%s\t%s\t%.02f\t%s\t|\n", name, age, man, phone, height, address);
		System.out.println(bar);
	}
}
