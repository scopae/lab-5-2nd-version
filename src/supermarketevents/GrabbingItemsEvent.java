package supermarketevents;

import customers.Customer;
import simulator.EventQueue;
import supermarket.SuperMarketState;

public class GrabbingItemsEvent extends ShoppingEvent {

	public GrabbingItemsEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Plocka", state, eventQueue, customer);
	}

	@Override
	public void execute() {
		if (state.availableCheckouts > 0) {
			state.availableCheckouts--;
			eventQueue.addEvent(new LeavingEvent(state.nextCheckoutTime(), state, eventQueue, customer));
		} else {
			state.checkoutQueue.add(customer);
		}
	}

}
