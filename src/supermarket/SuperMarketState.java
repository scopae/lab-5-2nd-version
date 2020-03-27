package supermarket;

import customers.Customer;
import customers.CustomerFactory;
import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.State;

public class SuperMarketState extends State {
	public boolean open = true;
	
	public final int totalCheckouts = 2;
	public int availableCheckouts = 2;

	public final int seed = 1234;
	public final double lambda = 4;
	public final double lowestCheckoutTime = 1.0;
	public final double highestCheckoutTime = 4.0;
	public final double lowestGrabbingItemsTime = 3.0;
	public final double highestGrabbingItemsTime = 8.0;
	
	public double accumulatedQueueTime = 0.00;
	public double accumulatedIdleTime = 0.00;
	
	public int visits;
	public int maximumCustomers;
	public int customersInStore;
	public int declinedCustomers;
	
	public CustomerFactory customerFactory = new CustomerFactory();
	
	public FIFO<Customer> checkoutQueue = new FIFO<Customer>();
	  
	 // Sets the boundaries for what the time variations can be picked from
	private UniformRandomStream checkoutTime = new UniformRandomStream(lowestCheckoutTime, highestCheckoutTime, seed);
	private ExponentialRandomStream timeToNextCustomerArrival = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream grabbingItemsTime = new UniformRandomStream(lowestGrabbingItemsTime, highestGrabbingItemsTime, seed);

	public double nextCheckoutTime() {
		return time + checkoutTime.next();
	}
	
	public double nextCustomerArrival() {
		return time + timeToNextCustomerArrival.next();
	}
	
	public double nextGrabbingItemsTime() {
		return time + grabbingItemsTime.next();
	}
	
}