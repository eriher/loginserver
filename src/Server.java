

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	private User test;
	private ServerSocket loginServerSocket;
	public FileManager fm;

	
	public Server(FileManager fm)
	{
		this.fm=fm;
		//test = new User("erik","hej");
		//fm.write(test);
		try {
			loginServerSocket = new ServerSocket(4444);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new LoginClientSocketReceiver(this,loginServerSocket);
    }
	
	public User checkLogin(String username, String password)
	{
		test = fm.read(username);
		if(test == null)
			return null;
		if((username.equals(test.login.getUsername()) && 
				(password.equals(test.login.getPassword()))))
				return test;
		else 
			return null;
	}

}
