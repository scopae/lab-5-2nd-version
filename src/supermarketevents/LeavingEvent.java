package supermarketevents;

import customers.Customer;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class LeavingEvent extends ShoppingEvent{


	public LeavingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Betalat", state, eventQueue, customer);
	}

	/**
	 * When a customer leaves the store adds 1 visit to the total and remove one from the current amount inside the store
	 * if there is a queue it works through it by letting the person first in line check out one at a time.
	 */
	public void execute() {
		state.visits++;
		state.customersInStore--;
		if (state.customersInStore == 0) {
			eventQueue.addEvent(new StopEvent(time, state, eventQueue));
		} else if (!state.checkoutQueue.isEmpty()) {
			eventQueue.addEvent(new LeavingEvent(state.nextCheckoutTime(), state, eventQueue, state.checkoutQueue.removeFirst()));
		} else {
			state.availableCheckouts++;
		}
	}

}
