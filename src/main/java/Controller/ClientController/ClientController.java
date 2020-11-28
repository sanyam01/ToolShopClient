package Controller.ClientController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;



import ClientModel.Customer;

/**
 * ClientController interacts with the Server
 * 
 * @author Sanyam, Neha
 *
 */
public class ClientController {
	
	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private int choice;
	private Boolean isConnected = true;
	private Customer customer;
	
	public ClientController(String serverName, int portNumber) throws ClassNotFoundException {
		
		try {
			
			aSocket = new Socket(serverName, portNumber);
			isConnected = true;
			
			// Socket input Stream
			//socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

			// Socket output Stream
			//socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			//runClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runClient() throws ClassNotFoundException, IOException {
		
		System.out.println("I am here");
		while(isConnected) {
			String response = "";
			
			
				//System.out.println("sending 1 to server");
//				socketOut.println("1");
//				socketOut.flush();
//				isConnected= false;
//				response = socketIn.readLine();
//				System.out.println("I got the" + response);
//				
//				
//		
//				System.out.println("I received the customer");
//				
//				ObjectMapper objectMapper = new ObjectMapper();
//				customer = objectMapper.readValue(response, Customer.class);
//				System.out.println(" Customer is " + customer.getCustomerID() + " " +customer.getFirstName());
			}
		closeConnection();
		}

	private void closeConnection() {
		
	try {
		socketOut.close();
		socketIn.close();
		aSocket.close();
	} catch (IOException e) {
		System.err.println("Cant close the connection");
		e.printStackTrace();
	}
		
	}

	public Socket getaSocket() {
		return aSocket;
	}

	public void setaSocket(Socket aSocket) {
		this.aSocket = aSocket;
	}
	
}
