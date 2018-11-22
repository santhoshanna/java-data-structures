package ds;
/**
 * 
 */

/**
 * @author cups
 *
 */
public class BasicStack<X> {

	private X[] data;
	private int stackPointer;

	@SuppressWarnings("unchecked")
	public BasicStack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
	}

	public void push(X newItem) {
		data[stackPointer++] = newItem;
	}

	public X pop() {
		if (stackPointer == 0) {
			throw new IllegalStateException("No More Items in Stack");
		}
		return data[--stackPointer];
	}

	public boolean contains(X item) {
		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	public X access(X item) {
		while (stackPointer > 0) {
			X temp = pop();
			if (temp.equals(item)) {
				return item;
			}
		}
		throw new IllegalStateException("No More Items in Stack");
	}

	public int size() {
		return stackPointer;
	}

}
