package ClientModel;

public class Commercial extends Customer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Commercial() {
		super();
	}

	public Commercial(int customerID, String firstName, String lastName, String address, String postalCode,
			String phoneNumber, String customerType) {
		super(customerID, firstName, lastName, address, postalCode, phoneNumber, customerType);
	}

}
