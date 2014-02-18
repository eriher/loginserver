

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginClientHandler extends Thread {
	
	private Socket	clientSocket;
	private Server	server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public LoginClientHandler(Server server,Socket clientSocket) {
		this.server = server;
		this.clientSocket = clientSocket;
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

