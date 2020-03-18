package simulator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;



public  class EventQueue<T extends State> {
	public List<Event<T>> eventQueue = new ArrayList<>();

	public void addEvent(Event<T> event) {
		eventQueue.add(event);
		Collections.sort(eventQueue);
	}

	public Event<?> nextEvent() {
		if (hasNext()) {
			return eventQueue.remove(0);
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public boolean hasNext() {
		return !eventQueue.isEmpty();
	}
	
}