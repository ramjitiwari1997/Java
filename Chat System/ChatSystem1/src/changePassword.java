import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
public class changePassword {
	private final String path="E:\\Server.dat";
	private boolean flag=false;
	private boolean isPassword=false;
	 ArrayList<User> list=new ArrayList<>();
	 User user;
	changePassword(String email) throws IOException, ClassNotFoundException
	{
		FileInputStream fi=new FileInputStream(path);
		ObjectInputStream oi=new ObjectInputStream(fi);
		while(true)
		{
			try
			{
			list.add((User)oi.readObject());
			}
			catch(EOFException e)
			{
				break;
			}
		}
		oi.close();
		fi.close();
		Iterator<User> userIterator=list.iterator();
		while(userIterator.hasNext())
		{
			 user=userIterator.next();
			if(email.equals(user.Email()))
				flag=true;
			
		}
	}
	public boolean getEmail()
	{
		return flag;
	}
	public void setPassword(String password) throws IOException
	{
		user.setPassword(password);
		FileOutputStream fo=new FileOutputStream(path,false);
		ObjectOutputStream os=new ObjectOutputStream(fo);
		Iterator<User> userITR=list.iterator();
		while(userITR.hasNext())
		{
			User user1=userITR.next();
			os.writeObject(user1);
		}
		os.close();
		fo.close();
	}
	public boolean oldPassword(String password)
	{
		if(password.equals(user.Password()))
		{
			isPassword=true;
		
		}
		return isPassword;
	}

}
