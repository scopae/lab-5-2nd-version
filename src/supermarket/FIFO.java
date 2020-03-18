package supermarket;

import java.util.Vector;
import java.util.NoSuchElementException;

public class FIFO<T> {
	// creates a vector that contains the list

	private Vector<T> fifoQueue = new Vector<T>();

	private int maxSize = 0;

	// returns the max size of the queue
	public int maxSize() {

		return maxSize;
	}

	// returns the size of the queue
	public int size() {

		return fifoQueue.size();
	}

	// adds an item to the queue and checks the size of the queue against the max
	// size
	public void add(T item) {

		fifoQueue.addElement(item);

		if (fifoQueue.size() > maxSize) {
			maxSize = fifoQueue.size();
		}

	}

	/**
	 * Removes the first object from the queue. If the queue is empty, a
	 * NoSuchElementException is thrown.
	 */
	public T removeFirst() {
		if (!isEmpty()) {
			return fifoQueue.remove(0);
		} else {
			throw new NoSuchElementException("The queue contains no objects");
		}
	}

	// throws an exception if there's no object at index 0, else it returns the
	// object
	public T first() {
		if (!isEmpty()) {
			return fifoQueue.elementAt(0);
		} else {
			throw new NoSuchElementException("there's no element here");
		}
	}

	// checks if the list is empty or contains element
	public boolean isEmpty() {
		return fifoQueue.size() == 0;
	}

	public boolean equals(Object f) {
		// tests if they are instances of the same type of object else throws an
		// exception
		if (this.getClass() != f.getClass()) {
			throw new ClassCastException("Please input a valid fifoqueue");
		}
		// checks if the sizes of the queues are the same
		if (fifoQueue.size() == ((FIFO) f).size()) {
			// iterates over the objects and logically checks if they hold the same value at
			// the same index

			for (int i = 0; i < fifoQueue.size(); i++) {

				// checks first if the first object isn't null while the second one is, then
				// checks if the first object is null while the second isn't
				if (this.fifoQueue.get(i) != null && ((FIFO) f).fifoQueue.get(i) == null) {
					return false;
				}

				else if (this.fifoQueue.get(i) == null && ((FIFO) f).fifoQueue.get(i) != null) {
					return false;

				}
				// checks if both elements are both null
				else if (this.fifoQueue.get(i) == null && ((FIFO) f).fifoQueue.get(i) == null) {

				}
				// evaluates have the same value
				else if (this.fifoQueue.get(i).equals(((FIFO) f).fifoQueue.get(i))) {

				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	// iterates over the array and adds the element at index i to a string and
	// returns it
	public String toString() {
		String objectsToPrint = "";
		for (int i = 0; i < fifoQueue.size(); i++) {
			objectsToPrint += "(" + String.valueOf(this.fifoQueue.elementAt(i)) + ") ";

		}
		return "Queue: " + objectsToPrint;
	}
}