package supermarket;

import simulator.Event;
import simulator.EventQueue;
import simulator.Simulator;

public class SuperMarketSimulator extends Simulator<SuperMarketState, SuperMarketView> {

	public SuperMarketSimulator(SuperMarketState state, SuperMarketView view, EventQueue<SuperMarketState> eventQueue) {
		super(state, view, eventQueue);
	}

	@Override
	public void run() {
		state.addObserver(view);
		
		while(state.running) {
			Event<SuperMarketState> event = eventQueue.nextEvent();
			
			double elapsedTime = event.time - state.time;
			state.accumulatedIdleTime += state.availableCheckouts * elapsedTime;
			state.accumulatedQueueTime += state.checkoutQueue.size() * elapsedTime;
			
			event.execute();
			state.time = event.time;
			 
			state.updateObservers(event);
		}
	}
	
}
