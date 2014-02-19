

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginClientSocketReceiver extends Thread{
	private ServerSocket serverSocket;
	
	public LoginClientSocketReceiver(ServerSocket serverSocket)
	{
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
				createLoginClientHandler(clientSocket);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void createLoginClientHandler(Socket clientSocket) {
		new LoginClientHandler(clientSocket);
		
	}	

}
