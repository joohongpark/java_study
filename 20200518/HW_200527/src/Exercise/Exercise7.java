package Exercise;

public class Exercise7 {
	public static void main(String[] args) {
		System.out.println( "String" ); // String
		System.out.println( 123 ); // integer
		System.out.println( 123.34 ); // double
	}
}

class chicken {
	public String chicken;
	public String source;
	public int qty;
	chicken(String chicken, String Source, int qty) {
		this.chicken = chicken;
	}
	void print() {
		System.out.printf("%s �ҽ��� ����� %s ġŲ %d����\n");
	}
}