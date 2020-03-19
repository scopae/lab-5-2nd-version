package simulator;

public abstract class Simulator<S extends State> {
	public S currentState;
	public EventQueue<S> eventQueue;
	
	public Simulator(S currentState, EventQueue<S> eventQueue) {
		this.currentState = currentState;
		this.eventQueue = eventQueue;
	}
	
	public abstract void run();
}