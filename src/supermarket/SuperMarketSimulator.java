package supermarket;

import simulator.EventQueue;
import simulator.Simulator;

public class SuperMarketSimulator extends Simulator<SuperMarketState> {

	public SuperMarketSimulator(SuperMarketState currentState, EventQueue<SuperMarketState> eventQueue) {
		super(currentState, eventQueue);
	}

	@Override
	public void run() {
		
	}
	
}
