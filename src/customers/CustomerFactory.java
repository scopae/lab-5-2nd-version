package customers;

public class CustomerFactory {
	private static int customerID =  0;
	
	public static Customer createCustomer() {
		return new Customer(customerID++);
	}
}