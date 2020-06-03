public class mainClass {
    static int outerField = 10;
	public static void main(String[] args) {
		System.out.println("Hello World");
		NestedClass.test();
		InnerClass i = new InnerClass();
	}
	class InnerClass {
	    void test() {
	        System.out.println("InnerClass");
	        System.out.println("Outer Class Access - " + outerField);
	    }
	}
	static class NestedClass {
	    static void test() {
	        System.out.println("NestedClass");
	        System.out.println("Outer Class Access - " + outerField);
	    }
	}
}