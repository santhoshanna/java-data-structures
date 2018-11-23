/**
 * 
 */
package ds;

/**
 * @author cups
 *
 */
public class BasicQueue<X> {

	private X[] data;
	private int front;
	private int end;

	public BasicQueue() {
		// data = (X[]) new Object[1000];
		this(1000);
	}

	@SuppressWarnings("unchecked")
	public BasicQueue(int size) {
		data = (X[]) new Object[size];
		this.front = -1;
		this.end = -1;
	}

	public int size() {
		if (end == -1 && front == -1) {
			return 0;
		} else
			return (end - front + 1);
	}

	public void enQueue(X item) {
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		if (this.size() == 0) {
			end++;
			front++;
			data[end] = item;
		} else {
			end++;
			data[end] = item;
		}
	}

	public X deQueue() {
		X item = null;
		if (this.size() == 0) {
			throw new IllegalStateException("Cant dequuue as the queue is empty!");
		} else if (front == end) {
			item = data[front];
			front = -1;
			end = -1;
		} else {
			item = data[front++];
		}
		return item;
	}

	public boolean contains(X item) {
		if (this.size() == 0) {
			return false;
		}
		for (int i = front; i < end; i++) {
			if (data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	public X access(int position) {
		if (this.size() == 0 || position > size()) {
			throw new IllegalArgumentException("No element in the position specified!");
		}
		int currentIndex = 0;
		for (int i = front; i < end; i++) {
			if (currentIndex == position) {
				return data[i];
			}
			currentIndex++;
		}
		throw new IllegalArgumentException("Could not find the item at the specified position!");
	}

}
