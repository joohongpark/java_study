package students;

public class mainClass {

	public static void main(String[] args) {
		allocParameter(1,2,3,4,5,6,7);

	}
	static void allocParameter( int ... param ) {
		int sum = 0;
		for (int i = 0; i < param.length; i++) {
			sum += param[i];
		}
		System.out.println(sum);
	}

}
