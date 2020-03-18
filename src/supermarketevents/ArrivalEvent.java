package supermarketevents;

import supermarket.SuperMarketState;
import simulator.EventQueue;
import customers.Customer;
import customers.CustomerFactory;

public class ArrivalEvent extends ShoppingEvent {
	

	public ArrivalEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Ankomst", state, eventQueue, customer);
	}

	@Override
	public void execute() {
		eventQueue.addEvent(new ArrivalEvent(state.nextCustomerArrival(), state, eventQueue, CustomerFactory.createCustomer()));
		
		if (state.customersInStore < state.maximumCustomers) {
			eventQueue.addEvent(new GrabbingItemsEvent(0.1, state, eventQueue, customer)); // TODO: set correct time
		} else {
			state.declinedCustomers++;
		}
	}
	
}