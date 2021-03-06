package supermarketevents;

import simulator.Event;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class StartingEvent extends Event<SuperMarketState> {

	public StartingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue) {
		super(time, "Butiken �ppnar", state, eventQueue);
	}

	//adds the first customer arrival and creates the first arrivalEvent
	public void execute() {
		state.open = true;
		eventQueue.addEvent(new ArrivalEvent(state.nextCustomerArrival(), state, eventQueue, state.customerFactory.createCustomer()));
	}
	
}
