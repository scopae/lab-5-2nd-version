package supermarket;

import customers.Customer;
import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.State;

public class SuperMarketState extends State {
	
	public final int totalCheckouts = 2;
	public int	availableCheckouts = 2;
	
	public final double lowestCheckoutTime = 1.0;
	public final double highestCheckoutTime = 4.0;
	
	public final double grossQueueTime = 0.00;
	public final double grossIdleTime = 0.00;
	
	public double formerCurrentTime = 0.00;
	public double formerGrossQueueTime = 0.00;
	
	public double lambda = 4;
	public final int seed = 1234;
	
	public int visits;
	public int maximumCustomers;
	public int customersInStore;
	public int declinedCustomers;
	
	public FIFO<Customer> checkoutQueue = new FIFO<Customer>();
	
	private UniformRandomStream checkoutTime = new UniformRandomStream(lowestCheckoutTime, highestCheckoutTime, seed);
	private ExponentialRandomStream timeToNextCustomerArrival = new ExponentialRandomStream(lambda, seed);

	public double nextCheckoutTime() {
		return time + checkoutTime.next();
	}
	
	public double nextCustomerArrival() {
		return time + timeToNextCustomerArrival.next();
	}
	
}