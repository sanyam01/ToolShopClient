package Controller.ClientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientControllerTool {

	private Socket toolSocket;
	private ClientController clientController;
	private PrintWriter socketOut;
	private BufferedReader socketIn;

	public ClientControllerTool() {
		super();

	}

	public void getSockets() {

		try {
			this.toolSocket = clientController.getaSocket();
			this.socketOut = new PrintWriter(toolSocket.getOutputStream(), true);
			this.socketIn = new BufferedReader(new InputStreamReader(toolSocket.getInputStream()));
		} catch (Exception e) {
		
			System.err.println("Unable to access the sockets in ClientControllerTool for connecting with server");
		}

	}

	public String sendQuery(String query) {
		
		String response = "";
		try {
			getSockets();
			socketOut.println(query);
			this.socketIn = new BufferedReader(new InputStreamReader(toolSocket.getInputStream()));
			response = response + socketIn.readLine();
			System.out.println("The input is " + response);
		} catch (Exception e) {
			System.err.println("Didn't get anything from server");
		}
		return response;
	}

	public Socket getToolSocket() {
		return toolSocket;
	}

	public void setToolSocket(Socket toolSocket) {
		this.toolSocket = toolSocket;
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
