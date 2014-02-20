import java.util.HashMap;
import java.util.LinkedList;


public class ServerCmd {
	
	private User test;
	public FileManager fm;
	
	public ServerCmd(FileManager fm){
		this.fm=fm;
		
	}
	
	public String createUser(String username, String password, String access)
	{
		test = new User(username, password, access);
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
	@SuppressWarnings("unchecked")
	public String modifySchedule(Object modsched)
	{
		test.modSched((HashMap<Integer, LinkedList<Day>>)modsched);
		fm.write(test);
		return new String("Schedule Modified");
	}
}
