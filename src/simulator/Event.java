package simulator;

public abstract class Event<S extends State> implements Comparable<Event<?>> {
	public final double time;
	public final String name;
	public S state;
	public EventQueue<S> eventQueue;
	public Event(double time, String name, S state, EventQueue<S> eventQueue) {
		this.time = time;
		this.name = name;
		this.state = state;
		this.eventQueue = eventQueue;
	}
	
	public String getEventName() {
		return name;
	}
	
	public abstract void execute();
	
	//orders the events
	
	public int compareTo(Event<?> event)  {
		return time < event.time
			? -1
			: time > event.time
				? 1
				: 0;
	}
}