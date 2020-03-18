package supermarketevents;
import simulator.EventQueue;
import simulator.State;
import supermarket.SuperMarketState;
import customers.CustomerFactory;
import customers.Customer;

public class ClosingEvent extends ShoppingEvent {

	public ClosingEvent(double time, SuperMarketState state, EventQueue<SuperMarketState> eventQueue, Customer customer) {
		super(time, "Butiken st�nger", state, eventQueue, customer);
	}

	@Override
	public void execute() {
		// TODO St�ng butiken
		state.stop();
	}

}
