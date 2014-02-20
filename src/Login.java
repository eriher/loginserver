

import java.io.Serializable;

public class Login implements Serializable{
	private static final long serialVersionUID = 8242531434630342834L;
	private String username;
	private String password;
	private String access;
	
	public Login(String name, String pass, String access)
	{
		username = name;
		password = pass;
		this.access =  access;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getAccess()
	{
		return access;
	}
}