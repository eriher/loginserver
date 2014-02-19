

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginClientHandler extends Thread {
	
	private Socket	clientSocket;
	private ServerCmd	server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public LoginClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		server = new ServerCmd(new FileManager());
		start();
	}
	
	public void run()
	{
		System.out.println("Connection recieved");
		try
		{
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			handleRequests();
	}

	private void handleRequests() {
		String[] request = null;
		while(true)
		{
			try
			{
				request = (String[])in.readObject();
			}
			catch(Exception e)
			{
				try
				{
					in.close();
					clientSocket.close();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				return;
			}
			if(request[0].equals("login"))
				try {
					out.writeObject((User)server.checkLogin(request[1],request[2]));
				} catch(IOException e){
					e.printStackTrace();
				}
			else if(request[0].equals("checkin"))
				try {
					out.writeObject((String)server.checkIn());
				} catch(IOException e){
					e.printStackTrace();
				}	
			else if(request[0].equals("checkout"))
				try {
					out.writeObject((String)server.checkOut());
				} catch(IOException e){
					e.printStackTrace();
				}	
			else if(request[0].equals("createuser"))
				try {
					out.writeObject((String)server.createUser(request[1],request[2]));
				} catch(IOException e){
					e.printStackTrace();
				}
			else
				try{
					System.out.println("Illegal request");
					out.writeObject("Illegal request");
				} catch(IOException e){
					e.printStackTrace();
				}
		}
	}
		
}

