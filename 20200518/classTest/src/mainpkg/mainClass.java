package mainpkg;

public class mainClass {
	public static void main(String[] args) {
		subClass sub1 = new subClass();
		subClass sub2 = new subClass();
		System.out.println(sub2.add(1,2));
		System.out.println(subClass.add(3,4));
		System.out.println(sub2.addinterface(3,4));
	}
}

