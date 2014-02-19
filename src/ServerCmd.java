
public class ServerCmd {
	
	private User test;
	public FileManager fm;
	
	public ServerCmd(FileManager fm){
		this.fm=fm;
		
	}
	
	public void createUser(String username, String password)
	{
		test = new User(username, password);
		fm.write(test);
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
