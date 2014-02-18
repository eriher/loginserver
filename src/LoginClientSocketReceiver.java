

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginClientSocketReceiver extends Thread{
	private Server server;
	private ServerSocket serverSocket;
	
	public LoginClientSocketReceiver(Server server, ServerSocket serverSocket)
	{
		this.server = server;
		this.serverSocket = serverSocket;
		start();
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Socket clientSocket = serverSocket.accept();
				createLoginClientHandler(server,clientSocket);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void createLoginClientHandler(Server server2, Socket clientSocket) {
		new LoginClientHandler(server2, clientSocket);
		
	}	

}
