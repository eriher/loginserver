

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class User implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1251343211799029911L;
	public Login login;
	public LinkedList<Day> week;
	public HashMap<Integer,LinkedList<Day>> schema;
	
	public User(String un, String pw, String access)
	{
		schema = new HashMap<Integer, LinkedList<Day>>();
		login = new Login(un,pw,access);
		for(int x=1;x<53;x++){
			week = new LinkedList<Day>();
			for(int y=1;y<8;y++){
				Day dag = new Day(x,y);
				week.add(dag);	
			}
			schema.put(x, week);
		}
	}
	
	public Login getLogin()
	{
		return login;
	}
	
	public HashMap<Integer, LinkedList<Day>> getschema()
	{
		return schema;
	}
	public LinkedList<Day> getCurrentWeek()
	{
		DateFormat dateFormat = new SimpleDateFormat("w");
		Date date = new Date();
		int x = Integer.parseInt(dateFormat.format(date));
		LinkedList<Day> currentweek = schema.get(x);
		return currentweek;
	}
	public Day getCurrentDay()
	{
		DateFormat dayFormat = new SimpleDateFormat("u");
		Date date = new Date();
		int x = Integer.parseInt(dayFormat.format(date));
		Day currentday = getCurrentWeek().get(x);
		return currentday;
	}
	public void modSched(HashMap<Integer, LinkedList<Day>> modsched)
	{
		for(int x=1;x<53;x++)
		{
			for(int y=0;y<7;y++){
				schema.get(x).get(y).setStart(modsched.get(x).get(y).getStart());
				schema.get(x).get(y).setSlut(modsched.get(x).get(y).getSlut());
			}
		}
	}
}
