package supermarketevents;

import simulator.Event;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class StartEvent extends Event<SuperMarketState> {

	public StartEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue) {
		super(time, "Start", state, eventQueue);
	}

	@Override
	public void execute() {
		state.running = true;
	}

}
