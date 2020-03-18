package supermarketevents;

import customers.Customer;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class LeavingEvent extends ShoppingEvent{


	public LeavingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Betalat", state, eventQueue, customer);
	}

	@Override
	public void execute() {
		state.visits++;
		state.customersInStore--;
		if (!state.checkoutQueue.isEmpty()) {
			eventQueue.addEvent(new LeavingEvent(state.nextCheckoutTime(), state, eventQueue, state.checkoutQueue.removeFirst()));
		} else {
			state.availableCheckouts++;
		}
	}

}
