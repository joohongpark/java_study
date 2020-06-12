package generic;

public class Box<T> {
	T t;
	public void SetT(T t) {
		this.t = t;
	}
	public T GetT() {
		return t;
	}
}
