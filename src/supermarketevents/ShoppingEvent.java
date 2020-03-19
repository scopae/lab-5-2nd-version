package supermarketevents;
import simulator.Event;
import simulator.EventQueue;
import simulator.State;
import supermarket.SuperMarketState;
import customers.CustomerFactory;
import customers.Customer;

public abstract class ShoppingEvent extends Event<SuperMarketState> {

	protected Customer customer;
	
	// Every shopping event contains a customer, a time and the state and queue it is in.
	public ShoppingEvent(double time, String name, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, name, state, eventQueue);
		this.customer = customer;
	}


}
