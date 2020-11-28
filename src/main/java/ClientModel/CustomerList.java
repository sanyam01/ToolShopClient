package ClientModel;

import java.io.Serializable;
import java.util.ArrayList;


public class CustomerList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * list of customers
	 */
	private ArrayList<Customer> customerList;
	
	public CustomerList() {
		super();
	}
	
	public CustomerList(ArrayList<Customer> list) {
		this.setCustomerList(list);
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
	public void addCustomers(Customer customer) {
		customerList.add(customer);

	}
	
}
