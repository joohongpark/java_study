package module;

class Parent {
	int x = 100;
	
	public Parent() {
		this(200);
	}
	public Parent(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}