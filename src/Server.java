

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private ServerSocket loginServerSocket;


	
	public Server()
	{


		try {
			loginServerSocket = new ServerSocket(4444);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new LoginClientSocketReceiver(loginServerSocket);
    }
}
