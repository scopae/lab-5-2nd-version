package supermarketevents;

import customers.CustomerFactory;
import simulator.Event;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class StartingEvent extends Event<SuperMarketState> {

	public StartingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue) {
		super(time, "Butiken �ppnar", state, eventQueue);
	}

	@Override
	public void execute() {
		eventQueue.addEvent(new ArrivalEvent(state.nextCustomerArrival(), state, eventQueue, CustomerFactory.createCustomer()));
	}
	
}