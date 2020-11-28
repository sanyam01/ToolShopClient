package Controller.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ClientModel.ElectricalItem;
import ClientView.ToolView;
import Controller.ModelController.ModelControllerTool;
import Controller.ViewController.CustomerViewController.CustomerListener;

/**
 * ToolViewController controls the Inventory View.
 * 
 * @author Sanyam, Neha
 *
 */
public class ToolViewController {

	private ToolView toolView;
	private ModelControllerTool modelControllerTool;

	public ToolViewController(ModelControllerTool modelControllerTool) {
		toolView = new ToolView();
		toolView.setVisible(true);
		toolView.pack();
		toolView.addToolListener(new ToolListener());
		this.modelControllerTool = modelControllerTool;
	}

	private void findSearchType() {
		if (toolView.getSearchToolID().isSelected())
			searchClientID();
		else if (toolView.getSearchToolName().isSelected())
			searchName();
		else {
			toolView.getStatusText().setText("Please select a valid search based type");
		}

	}

	private void searchClientID() {
		String toolID = toolView.getSearchParameter().getText();
		String response = modelControllerTool.searchToolID(toolID);
		if (response.split("!!")[0].strip().contentEquals("ERROR"))
			toolView.getStatusText().setText(response.split("!!")[1]);
		else {
			printToolListGUI(response);
			addListenerList();
		}

	}

	private void searchName() {
		String toolName = toolView.getSearchParameter().getText();
		String response = modelControllerTool.searchToolName(toolName);
		if (response.split("!!")[0].strip().contentEquals("ERROR")) {
			toolView.getStatusText().setText(response.split("!!")[1]);
			toolView.clearToolList();
		}
		else {
			printToolListGUI(response);
			addListenerList();
		}

	}

	private void findCheckQuantity() {
		if (toolView.getSearchToolID().isSelected())
			checkClientID();
		else if (toolView.getSearchToolName().isSelected())
			checkName();
		else
			toolView.getStatusText().setText("Please select a valid type for checking the quantity");

	}

	private void checkClientID() {

		String toolID = toolView.getSearchParameter().getText();
		String response = modelControllerTool.checkToolID(toolID);
		if (response.split("!!")[0].strip().contentEquals("ERROR"))
			toolView.getStatusText().setText(response.split("!!")[1]);
		else {
			printToolListGUI(response);
			addListenerList();
		}

	}

	private void checkName() {
		String name = toolView.getSearchParameter().getText();
		String response = modelControllerTool.checkToolName(name);
		if (response.split("!!")[0].strip().contentEquals("ERROR"))
			toolView.getStatusText().setText(response.split("!!")[1]);
		else {
			printToolListGUI(response);
			addListenerList();
		}

	}

	// getting all the tools
	private void getAllTools() {

		String response = modelControllerTool.getAllTools();
		if (response.split("!!")[0].strip().contentEquals("ERROR"))
			toolView.getStatusText().setText(response.split("!!")[1]);
		else {
			printToolListGUI(response);
			addListenerList();
		}

	}

	private void clearSearch() {
		toolView.getGroup().clearSelection();
		toolView.getSearchParameter().setText("");
		toolView.clearToolList();
		toolView.getOrder().setText("");
		toolView.getStatusText().setText("Clear Search has been performed");

	}

	private void clearItem() {

		System.out.println("Clear has been called");
		clearToolFields();
		toolView.getStatusText().setText("Item Info is cleared");
	}

	private void clearToolFields() {

		toolView.getToolID().setText("");
		toolView.getToolName().setText("");
		toolView.getToolType().setSelectedItem("");
		toolView.getToolPrice().setText("");
		toolView.getToolQuantity().setText("");
		toolView.getSupplierID().setText("");
		toolView.getPowerType().setText("");
	}

	private void decreaseItem() {
		System.out.println("Decrease has been called");
		String response = fetchItemInformation();
		if (response != "") {
		toolView.getStatusText().setText(response);
		clearToolFields();
		toolView.getToolList().clearSelection();
		toolView.getToolList().setEnabled(true);
		}
	}

	private String fetchItemInformation() {
		String response = "";
		try {
			int iD = Integer.parseInt(this.getToolView().getToolID().getText());
			response = this.modelControllerTool.sendItemInfoDecrease(iD);

		} catch (Exception e) {
			System.err.println("Please enter valid inputs here");
			this.toolView.getStatusText().setText("Please enter valid input ID");
		}
		return response;

	}

	// need
	private void getSelectedToolInfo(int index) {

		String values = this.modelControllerTool.getIndexTool(index);
		System.out.println("Values recieved to display on GUI are" + values);
		String[] data = values.split("!!!");
		if (data[2].contentEquals("Electrical"))
			setValuesToolGUI(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
		else
			setValuesToolGUI(data[0], data[1], data[2], data[3], data[4], data[5], "");

	}

	private void setValuesToolGUI(String itemID, String itemName, String itemType, String itemPrice,
			String itemQuantity, String supplierID, String powerType) {

		toolView.getToolID().setText(itemID);
		toolView.getToolName().setText(itemName);
		toolView.getToolPrice().setText(itemPrice);
		toolView.getToolQuantity().setText(itemQuantity);
		toolView.getSupplierID().setText(supplierID);
		toolView.getPowerType().setText(powerType);
		System.out.println("The value of ttpe is " + itemType);
		if (itemType.contentEquals("Electrical")) {
			toolView.getToolType().setSelectedIndex(1);

		} else
			toolView.getToolType().setSelectedIndex(2);

	}

	// method for adding action listeners to the list
	public void addListenerList() {
		toolView.addListenerList(new ToolListener());
	}
	

	private void printToolListGUI(String response) {
		toolView.addToolList(response);

	}

	public void printOrder() {

		String value = this.getModelControllerTool().printOrder();
		toolView.getOrder().setText(value);
//		printToolListGUI(value);
		toolView.getToolList().setEnabled(true);
	}

	public ToolView getToolView() {
		return toolView;
	}

	public void setToolView(ToolView toolView) {
		this.toolView = toolView;
	}

	public ModelControllerTool getModelControllerTool() {
		return modelControllerTool;
	}

	public void setModelControllerTool(ModelControllerTool modelControllerTool) {
		this.modelControllerTool = modelControllerTool;
	}

	class ToolListener implements ActionListener, ListSelectionListener {

		public void actionPerformed(ActionEvent e) {
			
			toolView.getToolList().setEnabled(true);
			toolView.getStatusText().setText("");
			if (e.getSource() == toolView.getSearch())
				findSearchType();
			if (e.getSource() == toolView.getListAllTools())
				getAllTools();
			if (e.getSource() == toolView.getClearSearch())
				clearSearch();
			if (e.getSource() == toolView.getDecrease())
				decreaseItem();
			if (e.getSource() == toolView.getClear())
				clearItem();
			if (e.getSource() == toolView.getCheckQuantity())
				findCheckQuantity();
			if (e.getSource() == toolView.getPrintOrder()) {
				toolView.getToolList().setEnabled(false);
				printOrder();
			}
			
		}

		public void valueChanged(ListSelectionEvent e) {

			if (toolView.getToolList().getSelectedIndex() == -1) {
				toolView.getToolList().clearSelection();
				toolView.getToolList().setEnabled(true);
			} else {
				toolView.getToolList().setEnabled(true);
				int index = toolView.getToolList().getSelectedIndex();
				System.out.println("First index is" + index);
				getSelectedToolInfo(index);
			}
		}

	}

}
