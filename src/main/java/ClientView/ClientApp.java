package ClientView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import ClientModel.LoginCredentials;

public class ClientApp extends JFrame implements LoginCredentials {

	private static final long serialVersionUID = 1L;
	private JTextField password;
	private JTextField ID;
	private JTextField status;
	private JButton enter;

	public ClientApp() {

		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());

		contentPanel.add("North", new JLabel("Login Window"));

		JPanel rightView = new JPanel(new GridLayout(3, 2, 2, 2));

		rightView.add(new JLabel("Password: "));
		password = new JTextField();
		rightView.add(password);

		rightView.add(new JLabel("ID: "));
		ID = new JTextField();
		rightView.add(ID);

		enter = new JButton("ENTER");
		rightView.add(enter);

		contentPanel.add("Center", rightView);

		status = new JTextField();
		contentPanel.add("South", status);

		this.getEnter().addActionListener(new AppListener());

	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JTextField getID() {
		return ID;
	}

	public void setID(JTextField iD) {
		ID = iD;
	}

	public JTextField getStatus() {
		return status;
	}

	public void setStatus(JTextField status) {
		this.status = status;
	}

	public JButton getEnter() {
		return enter;
	}

	public void setEnter(JButton enter) {
		this.enter = enter;
	}

	private void checkID() {

		if (this.getPassword().getText().contentEquals(Password) && this.getID().getText().contentEquals(LoginID)) {
			this.getStatus().setText("Login Successfull");
			createMainGUI();
			this.dispose();

		} else {
			this.getStatus().setText("Please try again");
		}

	}

	private void createMainGUI() {
		MainView mainView = new MainView();
		mainView.setVisible(true);
		mainView.pack();
	}

	class AppListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			checkID();

		}

	}

	public static void main(String[] args) {

		ClientApp app = new ClientApp();
		app.setPreferredSize(new Dimension(250, 250));
		app.setVisible(true);
		app.pack();
	}
}
