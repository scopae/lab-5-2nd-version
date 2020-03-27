package supermarketevents;

import simulator.Event;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class StopEvent extends Event<SuperMarketState> {

	public StopEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue) {
		super(time, "Stop", state, eventQueue);
	}

	@Override
	public void execute() {
		state.running = false;
	}

}
