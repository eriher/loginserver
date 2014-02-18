

import java.io.Serializable;

public class Day implements Serializable{
	

		/**
	 * 
	 */
	private static final long serialVersionUID = -8592734446181177749L;
		public int day;
		public int week;
		public String starttid 	= "";
		public String sluttid 	= "";
		public String checkin 	= "";
		public String checkout 	= "";
		
		public Day(int x, int y) {
			if(y==1)
				setStartTime("08:00");
			if(y==2)
				setStartTime("09:00");
			if(y==3)
				setStartTime("09:15");
			if(y==4)
				setStartTime("12:00");
			if(y==5)
				setStartTime("12:34");
			if(y==6)
				setStartTime("12:45");
			if(y==7)
				setStartTime("17:45");
			week = x;
			day = y;
		}
		
		public void setStartTime(String starttid){
			this.starttid = starttid;
		}
		public void setSlutTid(String sluttid){
			this.sluttid = sluttid;
		}
		public void setCheckIn(String checkin){
			this.checkin = checkin;
		}
		public void setCheckOut(String checkout){
			this.checkout = checkout;
		}
		public String day(){
			return Integer.toString(day);
		}
		public String week(){
			return Integer.toString(week);
		}
		public String getStart(){
			return starttid;
		}
		
}


