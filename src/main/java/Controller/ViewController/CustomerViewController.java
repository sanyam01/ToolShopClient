package Controller.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import ClientView.CustomerListener;
import ClientView.CustomerView;
import Controller.ModelController.ModelControllerCustomer;

/**
 * CustomerViewController controls the Customer View.
 * 
 * @author Sanyam, Neha
 *
 */
public class CustomerViewController {

	private CustomerView customerView;
	private ModelControllerCustomer modelControllerCustomer;

	public CustomerViewController(ModelControllerCustomer modelControllerCustomer) {

		customerView = new CustomerView();
		customerView.setVisible(true);
		customerView.pack();
		customerView.addCustomerListener(new CustomerListener());
		this.modelControllerCustomer = modelControllerCustomer;
	}

	// clears the search
	public void clearSearch() {
		customerView.getGroup().clearSelection();
		customerView.getSearchParameter().setText("");
		customerView.clearCustomerList();

	}

	// method is called when clear is called
	private void clearCustomer() {
		System.out.println("Clear has been called");
		clearCustomerFields();
		customerView.getStatusText().setText("Customer Info is cleared");
	}

	// displaying the info of the selected customer
	private void getSelectedCustInfo(int index) {

		String values = this.modelControllerCustomer.getIndexCustomer(index);
		System.out.println("Values recieved to display on GUI are" + values);
		String[] data = values.split("!!!");
		setValuesCustGUI(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);

	}

	// sets the passed values in GUI
	private void setValuesCustGUI(String id, String fname, String lname, String address, String postalCode,
			String phoneNumber, String type) {

		customerView.getCustomerID().setText(id);
		customerView.getFirstName().setText(fname);
		customerView.getLastName().setText(lname);
		customerView.getAddress().setText(address);
		customerView.getPostalCode().setText(postalCode);
		customerView.getPhoneNo().setText(phoneNumber);
		System.out.println("The value of ttpe is " + type);
		if (type.contentEquals("R"))
			customerView.getTypeCustomer().setSelectedIndex(1);
		else
			customerView.getTypeCustomer().setSelectedIndex(2);

	}

	// checks the type on which search is to be done for entered text
	public void findSearchType() {
		
			if (customerView.getSearchParameter().getText().equals(""))
				this.customerView.getStatusText().setText("Please enter the parameter");
			else if (customerView.getSearchCustomerID().isSelected())
				searchClientID();
			else if (customerView.getSearchLastName().isSelected())
				searchLastName();
			else if (customerView.getSearchCustomerType().isSelected())
				searchType();
			else
				this.customerView.getStatusText()
						.setText("Couldn't find an option on which valid search is to be made");
		}

	// gets the client ID and passes it
	private void searchClientID() {
		String clientID = customerView.getSearchParameter().getText();
		String response = modelControllerCustomer.searchClientID(clientID);
		if (response.split("!!")[0].strip().contentEquals("ERROR")) {
			this.customerView.getStatusText().setText(response);
			this.customerView.clearToolList();
		} else {
			printCustListGUI(response);
			addListenerList();
		}

	}

	private void searchLastName() {
		String lastName = customerView.getSearchParameter().getText();
		String response = modelControllerCustomer.searchLastName(lastName);
		if (response.split("!!")[0].strip().contentEquals("ERROR")) {
			this.customerView.getStatusText().setText(response);
			this.customerView.clearToolList();
		} else {
			printCustListGUI(response);
			addListenerList();
		}
	}

	private void searchType() {
		String type = customerView.getSearchParameter().getText();
		String response = modelControllerCustomer.searchCustomerType(type);
		if (response.split("!!")[0].strip().contentEquals("ERROR")) {
			this.customerView.getStatusText().setText(response);
			this.customerView.clearToolList();
		} else {
			printCustListGUI(response);
			addListenerList();
		}
	}

	// method for adding action listeners to the list
	public void addListenerList() {
		customerView.addListenerList(new CustomerListener());
	}

	private void printCustListGUI(String response) {
		customerView.addCustomerList(response);

	}

	public CustomerView getCustomerView() {
		return customerView;
	}

	private void deleteCustomer() {
		if (checkInputs())
			customerView.getStatusText().setText("Please enter all the inputs");
		else {
		System.out.println("Delete has been called");
		fetchCustomerInformation();
		String response = modelControllerCustomer.sendCustomerInfoDelete();
		this.customerView.getStatusText().setText(response);
		customerView.getCustomerList().clearSelection();
		customerView.getCustomerList().setEnabled(true);
		clearCustomerFields();
	}
	}

	// method for saving the customer info
	public void saveCustomer() {
		if (checkInputs())
			customerView.getStatusText().setText("Please enter all the inputs");
		else {
		
		System.out.println("Save has been called");
		fetchCustomerInformation();
		String response = modelControllerCustomer.sendCustomerInfo();
		customerView.getStatusText().setText(response);
		}
	}

	public boolean checkInputs() {
		
		boolean check = false;
		
		if(this.getCustomerView().getCustomerID().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getFirstName().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getLastName().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getAddress().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getPostalCode().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getPhoneNo().getText().contentEquals(""))
			check = true;
		if(this.getCustomerView().getTypeCustomer().getSelectedItem() == "")
			check = true;
		
		return check;
	}
	// reads information of the customer from GUI
	public void fetchCustomerInformation() {

		try {

			int iD = Integer.parseInt(this.getCustomerView().getCustomerID().getText());
			String firstName = this.getCustomerView().getFirstName().getText();
			String lastName = this.getCustomerView().getLastName().getText();
			String address = this.getCustomerView().getAddress().getText();
			String postalCode = this.getCustomerView().getPostalCode().getText();
			String phoneNo = this.getCustomerView().getPhoneNo().getText();
			String type = (String) this.getCustomerView().getTypeCustomer().getSelectedItem();
			
			System.out.println("Selecte item is " + type);
			this.modelControllerCustomer.setCustomer(iD, firstName, lastName, address, postalCode, phoneNo, type);
		} catch (Exception e) {
			this.getCustomerView().getStatusText().setText("Please enter valid inputs");
		}
	}

	public void clearCustomerFields() {
		customerView.getCustomerID().setText("");
		customerView.getFirstName().setText("");
		customerView.getLastName().setText("");
		customerView.getAddress().setText("");
		customerView.getPostalCode().setText("");
		customerView.getPhoneNo().setText("");
		customerView.getTypeCustomer().setSelectedItem("");
	}

	public void setCustomerView(CustomerView customerView) {
		this.customerView = customerView;
	}

	public ModelControllerCustomer getModelControllerCustomer() {
		return modelControllerCustomer;
	}

	class CustomerListener implements ActionListener, ListSelectionListener {

		public void actionPerformed(ActionEvent e) {

			customerView.getStatusText().setText("");
			if (e.getSource() == customerView.getSearch())
				findSearchType();
			if (e.getSource() == customerView.getSave())
				saveCustomer();
			if (e.getSource() == customerView.getDelete())
				deleteCustomer();
			if (e.getSource() == customerView.getClear())
				clearCustomer();
			if (e.getSource() == customerView.getClearSearch())
				clearSearch();

		}

		public void valueChanged(ListSelectionEvent e) {

			if (customerView.getCustomerList().getSelectedIndex() == -1) {
				customerView.getCustomerList().clearSelection();
				customerView.getCustomerList().setEnabled(true);
			} else {
				customerView.getCustomerList().setEnabled(true);
				int index = customerView.getCustomerList().getSelectedIndex();
				System.out.println("First index is" + index);
				getSelectedCustInfo(index);
			}
		}

	}

}
