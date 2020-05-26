package mainpkg;

public class subClass {
	private static int i = 0;
	public static int j = 0;
	int geti() {
		return i;
	}
	void inci() {
		i++;
	}
    public static int add(int a, int b) {
        return a + b;
    }
    public int addinterface(int a, int b) {
        return add(a, b);
    }
}