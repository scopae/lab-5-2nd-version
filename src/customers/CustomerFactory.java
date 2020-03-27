package customers;

public class CustomerFactory {
	private int customerID =  0;
	
	public Customer createCustomer() {
		return new Customer(customerID++);
	}
}