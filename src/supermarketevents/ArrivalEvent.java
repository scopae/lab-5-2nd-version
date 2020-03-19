package supermarketevents;

import supermarket.SuperMarketState;
import simulator.EventQueue;
import customers.Customer;
import customers.CustomerFactory;

public class ArrivalEvent extends ShoppingEvent {
	

	public ArrivalEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Ankomst", state, eventQueue, customer);
	}

	/* If the store is open, and there is space adds a new customer and a new grabbingitemsevent.
	 * If the store is open and full, it increases the counter for declined customers
	 */
	public void execute() {
		if(state.isOpen) 
		eventQueue.addEvent(new ArrivalEvent(state.nextCustomerArrival(), state, eventQueue, CustomerFactory.createCustomer()));
		
		if (state.customersInStore < state.maximumCustomers) {
			eventQueue.addEvent(new GrabbingItemsEvent(state.nextGrabbingItemsTime(), state, eventQueue, customer));
		} else {
			state.declinedCustomers++;
		}
	}
	
}