
public class ServerCmd {
	
	private User test;
	public FileManager fm;
	
	public ServerCmd(FileManager fm){
		this.fm=fm;
		
	}
	
	public String createUser(String username, String password)
	{
		test = new User(username, password);
		fm.write(test);
		if(fm.read(username).getLogin().getUsername().equals(username))
			return new String("User "+username+" created!");
		else
			return null;
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
	public String checkIn()
	{
		test.getCurrentDay().setCheckIn();
		return test.getCurrentDay().getCheckIn();
	}
	public String checkOut()
	{
		test.getCurrentDay().setCheckOut();
		return test.getCurrentDay().getCheckOut();
	}
}
