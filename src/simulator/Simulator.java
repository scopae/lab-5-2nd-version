package simulator;

public abstract class Simulator<S extends State, V extends View> {
	public S state;
	public V view;
	public EventQueue<S> eventQueue;
	
	public Simulator(S state, V view, EventQueue<S> eventQueue) {
		this.state = state;
		this.view = view;
		this.eventQueue = eventQueue;
	}
	
	public abstract void run();
}