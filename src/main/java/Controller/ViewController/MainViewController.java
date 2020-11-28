package Controller.ViewController;

import ClientView.*;
import Controller.ClientController.ClientController;
import Controller.ModelController.ModelControllerCustomer;
import Controller.ModelController.ModelControllerTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewController implements ActionListener {

	MainView view;
	private CustomerViewController customerViewController;
	private ToolViewController toolViewController;
	private ClientController clientController;

	public MainViewController(MainView view) {
		this.view = view;
		try {
			clientController = new ClientController("localhost", 9090);
		} catch (ClassNotFoundException e) {
			System.out.println("Inside ClientControllerCustomer server not found");
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.getCustomerView()) {
			System.out.println("CustomerView");
			customerViewController = new CustomerViewController(new ModelControllerCustomer());
			customerViewController.getModelControllerCustomer().getClientControllerCustomer()
					.setClientController(clientController);
			customerViewController.getModelControllerCustomer().getClientControllerCustomer().getSockets();

		}

		else if (e.getSource() == view.getToolView()) {
			System.out.println("ToolView");
			toolViewController = new ToolViewController(new ModelControllerTool());
			toolViewController.getModelControllerTool().getClientControllerTool().setClientController(clientController);
			toolViewController.getModelControllerTool().getClientControllerTool().getSockets();

		}

	}
}