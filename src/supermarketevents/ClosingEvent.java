package supermarketevents;

import simulator.EventQueue;
import supermarket.SuperMarketState;
import customers.Customer;

public class ClosingEvent extends ShoppingEvent {

	public ClosingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Butiken stänger", state, eventQueue, customer);
	}

	/**
	 * Disables new arrivalevents
	 */
	public void execute() {
		state.open = false;
		
		if (state.customersInStore == 0) {
			eventQueue.addEvent(new StopEvent(time, state, eventQueue));
		}
	}

}
