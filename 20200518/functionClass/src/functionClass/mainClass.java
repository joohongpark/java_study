package functionClass;
public class mainClass {
	public static void main(String[] args) {
	    // ���� �ʵ� Initialize
	    constructor_ex e1 = new constructor_ex();
	    //e1.field = 10;
	    
	    // �����ڸ� ���� ���� �ʵ� Initialize
	    constructor_ex e2 = new constructor_ex(20);
	    
		System.out.println(e1.field);
		System.out.println(e2.field);
	}

}
class constructor_ex {
    public int field;
    constructor_ex(int field) {
        this.field = field;
    }
    constructor_ex() {
    	System.out.println(field);
    }
}