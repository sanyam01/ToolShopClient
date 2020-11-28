package Controller.ClientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientControllerCustomer {

	private Socket customerSocket;
	private ClientController clientController;
	private PrintWriter socketOut;
	private BufferedReader socketIn;

	public ClientControllerCustomer() {

	}

	public void getSockets() {
		try {
			this.customerSocket = clientController.getaSocket();
			this.socketIn = new BufferedReader(new InputStreamReader(customerSocket.getInputStream()));
			this.socketOut = new PrintWriter(customerSocket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String sendQuery(String query) {

		String response = "";

		try {
			getSockets();
			socketOut.println(query);
			this.socketIn = new BufferedReader(new InputStreamReader(customerSocket.getInputStream()));
			response = response + socketIn.readLine();
		} catch (IOException e) {
			System.out.println("Didn't get any response from server in Client Controller Customer");
		}
		return response;
	}

	public Socket getCustomerSocket() {
		return customerSocket;
	}

	public void setCustomerSocket(Socket customerSocket) {
		this.customerSocket = customerSocket;
	}

	public ClientController getClientController() {
		return clientController;
	}

	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}

	public PrintWriter getSocketOut() {
		return socketOut;
	}

	public BufferedReader getSocketIn() {
		return socketIn;
	}

}
