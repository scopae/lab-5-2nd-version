package customers;

public class Customer {
	private final int customerID;
	private double arrivedAt;
	
	public Customer(int customerID) {	
		this.customerID = customerID;
	}

	public int getCustomerID( int customerID) {
		return customerID;
	}
	
	public double getArrivalTime(double arrivedAT) {
		return arrivedAT;
	}

}