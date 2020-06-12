package stack;

public class ArrayStack {
	private int top;
	private int maxSize;
	private Object[] stack;

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == (maxSize - 1);
	}
}
