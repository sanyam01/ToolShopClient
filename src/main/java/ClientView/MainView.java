package ClientView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.ViewController.MainViewController;

public class MainView extends JFrame {

	private JLabel prompt;
	private JButton CustomerView;
	private JButton ToolView;

	public MainView() {

		prompt = new JLabel("Click for the customer view or tool view");
		CustomerView = new JButton("Customer View");
		ToolView = new JButton("Tool View");
		
		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());

		contentPanel.add("North", prompt);
		contentPanel.add("East", CustomerView);
		contentPanel.add("West", ToolView);

		MainViewController mvc = new MainViewController(this);

		CustomerView.addActionListener(mvc);
		ToolView.addActionListener(mvc);

	}

	public JButton getCustomerView() {
		return CustomerView;
	}

	public void setCustomerView(JButton customerView) {
		CustomerView = customerView;
	}

	public JButton getToolView() {
		return ToolView;
	}

	public void setToolView(JButton toolView) {
		ToolView = toolView;
	}

//	public static void main(String[] args) {
//		MainView mainView = new MainView();
//		mainView.setVisible(true);
//		mainView.pack();
//	}

}
