package ClientView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class ToolView extends JFrame {

	private JButton checkQuantity;
	private JButton decrease;
	private JButton clear;
	private JTextField toolID;
	private JTextField toolName;
	private JComboBox toolType;
	private JTextField toolQuantity;
	private JTextField toolPrice;
	private JTextField supplierID;
	private JTextField powerType;
	private JTextField statusText;
	private JTextArea displayText;
	private JRadioButton searchToolID;
	private JRadioButton searchToolName;
	private JTextField searchParameter;
	private JButton search;
	private JButton clearSearch;
	private JList toolList;
	private JButton listAllTools;
	private JButton printOrder;
	private JTextArea order;

	private ButtonGroup group;

	public ToolView() {

		// high-level container
		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());

		contentPanel.add("North", new JLabel("Tool Management Screen"));

		JPanel rightView = new JPanel(new BorderLayout());// JPanel for adding right side of Client GUI
		rightView.add("North", new JLabel("Tool Information"));

		JPanel buttons = new JPanel();// JPanel for adding for adding buttons Save, delete, and clear

		checkQuantity = new JButton("Check Quantity");
		decrease = new JButton("Decrease");
		clear = new JButton("Clear");

		// adding buttons to JPanel
		// buttons.add(checkQuantity);
		buttons.add(decrease);
		buttons.add(clear);

		rightView.add("South", buttons);// added buttons to the rightView

		JPanel centerRightView = new JPanel();
		centerRightView.setLayout(new GridLayout(8, 2, 2, 2));

		centerRightView.add(new JLabel("ToolID"));// adding toolID
		toolID = new JTextField(20);
		centerRightView.add(toolID);

		centerRightView.add(new JLabel("Name"));// adding Name
		toolName = new JTextField();
		centerRightView.add(toolName);

		String[] toolTypeString = { "", "Electrical", "Non-Electrical" };// type of residents
		centerRightView.add(new JLabel("Tool type"));// adding residential type
		toolType = new JComboBox(toolTypeString);
		centerRightView.add(toolType);

		centerRightView.add(new JLabel("Tool Quantity"));// adding Tool Quantity
		toolQuantity = new JTextField();
		centerRightView.add(toolQuantity);

		centerRightView.add(new JLabel("Tool Price"));// adding tool price
		toolPrice = new JTextField();
		centerRightView.add(toolPrice);

		centerRightView.add(new JLabel("Supplier ID"));// adding Phone no
		supplierID = new JTextField();
		centerRightView.add(supplierID);

		centerRightView.add(new JLabel("Power Type"));// adding power type
		powerType = new JTextField();
		centerRightView.add(powerType);

		centerRightView.add(new JLabel("Operation status"));
		statusText = new JTextField();
		centerRightView.add(statusText);

		rightView.add("Center", centerRightView);
		contentPanel.add("East", rightView);

		JPanel leftView = new JPanel(new BorderLayout());

		//JPanel leftViewSouth = new JPanel(new GridLayout(3,1));//added new
		JPanel leftViewSouth = new JPanel(new BorderLayout());
		toolList = new JList();
		

		JScrollPane scroll = new JScrollPane(toolList);
		
		//leftViewSouth.add(scroll);//added new
		//leftViewSouth.add(new JLabel("Print Order Here"));//added new
		order = new JTextArea(10,5);//added new
		//leftViewSouth.add(order);//added new
		leftViewSouth.add("North", scroll);
		leftViewSouth.add("Center", new JLabel("Print Order Here"));
		leftViewSouth.add("South", order);
		
		
		
		leftView.add("South", leftViewSouth);

		JPanel leftNorth = new JPanel(new GridLayout(8, 1, 2, 2));
		leftNorth.add(new JLabel("Search Tools"));
		leftNorth.add(new JLabel("Select type of search to be performed"));

		searchToolID = new JRadioButton("Tool ID");
		searchToolName = new JRadioButton("Name");

		group = new ButtonGroup();
		group.add(searchToolID);
		group.add(searchToolName);

		leftNorth.add(searchToolID);
		leftNorth.add(searchToolName);
		leftNorth.add(new JLabel("Enter the search parameter below"));

		JPanel leftViewButtons = new JPanel();// for adding text field, search and clear search
		searchParameter = new JTextField(20);// for inputting the search text
		search = new JButton("Search");
		clearSearch = new JButton("Clear Search");
		listAllTools = new JButton("List Tools");
		printOrder = new JButton("Print Order");

		leftViewButtons.add(searchParameter);
		leftViewButtons.add(checkQuantity);
		leftViewButtons.add(search);
		leftViewButtons.add(clearSearch);
		leftViewButtons.add(listAllTools);
		leftViewButtons.add(printOrder);
		leftNorth.add(leftViewButtons);
		leftNorth.add(new JLabel("Search Results :"));
		leftView.add("North", leftNorth);

		contentPanel.add("West", leftView);

	}

	public void addToolListener(ActionListener toolListener) {

		checkQuantity.addActionListener(toolListener);
		decrease.addActionListener(toolListener);
		clear.addActionListener(toolListener);
		searchParameter.addActionListener(toolListener);
		search.addActionListener(toolListener);
		clearSearch.addActionListener(toolListener);
		listAllTools.addActionListener(toolListener);
		printOrder.addActionListener(toolListener);

	}

	// adding tool list to the GUI
	public void addToolList(String list) {

		toolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		toolList.setLayoutOrientation(JList.VERTICAL_WRAP);
		String[] listArray = list.split("\n");
		toolList.setListData(listArray);

	}

	// method for adding action listeners to the list
	public void addListenerList(ListSelectionListener toolListener) {
		ListSelectionModel listSelectionModel = toolList.getSelectionModel();
		listSelectionModel.addListSelectionListener(toolListener);
	}

	// clears the list
	public void clearToolList() {
		String[] listArray = {};
		toolList.setListData(listArray);

	}

	public JComboBox getToolType() {
		return toolType;
	}

	public JButton getCheckQuantity() {
		return checkQuantity;
	}

	public void setCheckQuantity(JButton checkQuantity) {
		this.checkQuantity = checkQuantity;
	}

	public JButton getDecrease() {
		return decrease;
	}

	public void setDecrease(JButton decrease) {
		this.decrease = decrease;
	}

	public JTextField getStatusText() {
		return statusText;
	}

	public void setStatusText(JTextField statusText) {
		this.statusText = statusText;
	}

	public JButton getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(JButton printOrder) {
		this.printOrder = printOrder;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JTextField getToolID() {
		return toolID;
	}

	public void setToolID(JTextField toolID) {
		this.toolID = toolID;
	}

	public JTextField getToolName() {
		return toolName;
	}

	public void setToolName(JTextField toolName) {
		this.toolName = toolName;
	}

	public JList getToolList() {
		return toolList;
	}

	public void setToolList(JList toolList) {
		this.toolList = toolList;
	}

	public JButton getListAllTools() {
		return listAllTools;
	}

	public void setListAllTools(JButton listAllTools) {
		this.listAllTools = listAllTools;
	}

	public void setToolType(JComboBox toolType) {
		this.toolType = toolType;
	}

	public JTextField getToolQuantity() {
		return toolQuantity;
	}

	public void setToolQuantity(JTextField toolQuantity) {
		this.toolQuantity = toolQuantity;
	}

	public JTextField getToolPrice() {
		return toolPrice;
	}

	public void setToolPrice(JTextField toolPrice) {
		this.toolPrice = toolPrice;
	}

	public JTextField getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(JTextField supplierID) {
		this.supplierID = supplierID;
	}

	public JTextArea getDisplayText() {
		return displayText;
	}

	public void setDisplayText(JTextArea displayText) {
		this.displayText = displayText;
	}

	public JRadioButton getSearchToolID() {
		return searchToolID;
	}

	public void setSearchToolID(JRadioButton searchToolID) {
		this.searchToolID = searchToolID;
	}

	public JRadioButton getSearchToolName() {
		return searchToolName;
	}

	public void setSearchToolName(JRadioButton searchToolName) {
		this.searchToolName = searchToolName;
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

	public JTextField getPowerType() {
		return powerType;
	}

	public void setPowerType(JTextField powerType) {
		this.powerType = powerType;
	}

	public JTextArea getOrder() {
		return order;
	}

	public void setOrder(JTextArea order) {
		this.order = order;
	}
	
	

}
