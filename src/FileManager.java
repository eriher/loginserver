import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class FileManager {
	public FileManager(){
	}
		
		private FileInputStream inStream;
		ObjectInputStream reader;
		private ObjectOutputStream outStream;
		


		public void write(User user)
		{
			try{
			outStream = new ObjectOutputStream(new FileOutputStream(user.getLogin().getUsername()+".ser"));
			outStream.writeObject(user);
			outStream.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		public User read(String un)
		{
			User user = null;
			try{
				inStream = new FileInputStream(un+".ser");
			}
				catch(FileNotFoundException e)
				{
					return null;
				}
			try{
				reader = new ObjectInputStream(inStream);
			}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				try {
					user = (User) reader.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return user;
			}

		}
			
