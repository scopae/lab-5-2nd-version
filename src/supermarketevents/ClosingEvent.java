package supermarketevents;
import simulator.EventQueue;
import simulator.State;
import supermarket.SuperMarketState;
import customers.CustomerFactory;
import customers.Customer;

public class ClosingEvent extends ShoppingEvent {

	public ClosingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Butiken stänger", state, eventQueue, customer);
	}

	/*Disables new arrivalevents
	 * When all customers still remaining have left the store, stops the simulation
	 * 
	 * 
	 */
	public void execute() {
		
		// TODO Stäng butiken
		state.stop();
	}

}
