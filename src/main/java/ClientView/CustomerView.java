package ClientView;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

//import Client.Controller.ViewController.CustomerViewController.CustomerListener;

public class CustomerView extends JFrame {

	private JButton save;
	private JButton delete;
	private JButton clear;
	private JTextField customerID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField postalCode;
	private JTextField phoneNo;
	private JComboBox typeCustomer;
	private JTextArea displayText;
	private JTextField statusText;
	private JRadioButton searchCustomerID;
	private JRadioButton searchLastName;
	private JRadioButton searchCustomerType;
	private JTextField searchParameter;
	private JButton search;
	private JButton clearSearch;
	private JList customerList;// for adding the search results

	private ButtonGroup group;

	public CustomerView() {

		// high-level container
		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());

		contentPanel.add("North", new JLabel("Customer Management Screen"));

		JPanel rightView = new JPanel(new BorderLayout());// JPanel for adding right side of Customer GUI
		rightView.add("North", new JLabel("Customer Information"));

		JPanel buttons = new JPanel();// JPanel for adding for adding buttons Save, delete, and clear

		save = new JButton("Save");
		delete = new JButton("Delete");
		clear = new JButton("Clear");

		// adding buttons to JPanel
		buttons.add(save);
		buttons.add(delete);
		buttons.add(clear);

		rightView.add("South", buttons);// added buttns to the rightView

		JPanel centerRightView = new JPanel();
		centerRightView.setLayout(new GridLayout(8, 2, 2, 2));

		centerRightView.add(new JLabel("CustomerID"));// adding CustomerID
		customerID = new JTextField(20);
		centerRightView.add(customerID);

		centerRightView.add(new JLabel("First Name"));// adding firstName
		firstName = new JTextField();
		centerRightView.add(firstName);

		centerRightView.add(new JLabel("Last Name "));// adding lastName
		lastName = new JTextField();
		centerRightView.add(lastName);

		centerRightView.add(new JLabel("Address"));// adding Address
		address = new JTextField();
		centerRightView.add(address);

		centerRightView.add(new JLabel("Postal Code"));// adding Postal Code
		postalCode = new JTextField();
		centerRightView.add(postalCode);

		centerRightView.add(new JLabel("Phone no"));// adding Phone no
		phoneNo = new JTextField();
		centerRightView.add(phoneNo);

		String[] customerTypeString = {"", "R", "C"};// type of residents
		centerRightView.add(new JLabel("Customer type"));// adding residential type
		typeCustomer = new JComboBox(customerTypeString);
		centerRightView.add(typeCustomer);

		centerRightView.add(new JLabel("Operation status"));
		statusText = new JTextField();
		centerRightView.add(statusText);

		rightView.add("Center", centerRightView);
		contentPanel.add("East", rightView);

		JPanel leftView = new JPanel(new BorderLayout());

		//JPanel leftViewSouth = new JPanel(new GridLayout(3,1,2,2));//added new
		
		customerList = new JList();
		JScrollPane scroll = new JScrollPane(customerList);
		
//		leftViewSouth.add(scroll);//added new
//		leftViewSouth.add(new JLabel("Print Order Here"));//added new
//		order = new JTextArea();//added new
//		leftViewSouth.add(order);//added new
		
		//leftView.add("South", scroll);commented
		leftView.add("South", scroll);

		JPanel leftNorth = new JPanel(new GridLayout(8, 1, 2, 2));
		leftNorth.add(new JLabel("Search Customers"));
		leftNorth.add(new JLabel("Select type of search to be performed"));

		searchCustomerID = new JRadioButton("Customer ID");
		searchLastName = new JRadioButton("Last Name");
		searchCustomerType = new JRadioButton("Cient Type");

		group = new ButtonGroup();
		group.add(searchCustomerID);
		group.add(searchLastName);
		group.add(searchCustomerType);

		leftNorth.add(searchCustomerID);
		leftNorth.add(searchLastName);
		leftNorth.add(searchCustomerType);
		leftNorth.add(new JLabel("Enter the search parameter below"));

		JPanel leftViewButtons = new JPanel();// for adding text field, search and clear search
		searchParameter = new JTextField(20);// for inputting the search text
		search = new JButton("Search");
		clearSearch = new JButton("Clear Search");

		leftViewButtons.add(searchParameter);
		leftViewButtons.add(search);
		leftViewButtons.add(clearSearch);
		leftNorth.add(leftViewButtons);
		leftNorth.add(new JLabel("Search Results :"));
		leftView.add("North", leftNorth);

		contentPanel.add("West", leftView);

	}

	public void addCustomerListener(ActionListener customerListener) {
		// TODO Auto-generated method stub
		search.addActionListener(customerListener);
		save.addActionListener(customerListener);
		delete.addActionListener(customerListener);
		clear.addActionListener(customerListener);
		search.addActionListener(customerListener);
		clearSearch.addActionListener(customerListener);
	}

	// adding customer list to the GUI
	public void addCustomerList(String list) {

		customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerList.setLayoutOrientation(JList.VERTICAL_WRAP);
		String[] listArray = list.split("\n");
		customerList.setListData(listArray);

	}
	public void clearToolList() {
		String[] listArray = {};
		customerList.setListData(listArray);

	}
	public void clearCustomerList() {
		customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerList.setLayoutOrientation(JList.VERTICAL_WRAP);
		String[] listArray = {};
		customerList.setListData(listArray);
	}

	// method for adding action listeners to the list
	public void addListenerList(ListSelectionListener customerListener) {
		ListSelectionModel listSelectionModel = customerList.getSelectionModel();
		listSelectionModel.addListSelectionListener(customerListener);
	}

	public JList getCustomerList() {
		return customerList;
	}

	public void setCustomerList(JList customerList) {
		this.customerList = customerList;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JTextField getCustomerID() {
		return customerID;
	}

	public void setCustomerID(JTextField customerID) {
		this.customerID = customerID;
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(JTextField postalCode) {
		this.postalCode = postalCode;
	}

	public JTextField getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(JTextField phoneNo) {
		this.phoneNo = phoneNo;
	}

	public JComboBox getTypeCustomer() {
		return typeCustomer;
	}

	public void setTypeCustomer(JComboBox typeCustomer) {
		this.typeCustomer = typeCustomer;
	}

	public JTextArea getDisplayText() {
		return displayText;
	}

	public void setDisplayText(JTextArea displayText) {
		this.displayText = displayText;
	}

	public JRadioButton getSearchCustomerID() {
		return searchCustomerID;
	}

	public void setSearchCustomerID(JRadioButton searchCustomerID) {
		this.searchCustomerID = searchCustomerID;
	}

	public JRadioButton getSearchLastName() {
		return searchLastName;
	}

	public void setSearchLastName(JRadioButton searchLastName) {
		this.searchLastName = searchLastName;
	}

	public JRadioButton getSearchCustomerType() {
		return searchCustomerType;
	}

	public void setSearchCustomerType(JRadioButton searchCustomerType) {
		this.searchCustomerType = searchCustomerType;
	}

	public JTextField getSearchParameter() {
		return searchParameter;
	}

	public void setSearchParameter(JTextField searchParameter) {
		this.searchParameter = searchParameter;
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getClearSearch() {
		return clearSearch;
	}

	public void setClearSearch(JButton clearSearch) {
		this.clearSearch = clearSearch;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JTextField getStatusText() {
		return statusText;
	}

	public void setStatusText(JTextField statusText) {
		this.statusText = statusText;
	}

}
