import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String email;
	String password;
	String gender;
	String birthdate;
	User(String name,String email,String password,String gender,String birthdate)
	{
		this.name=name;
		this.email=email;
		this.password=password;
		this.gender=gender;
		this.birthdate=birthdate;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String Email()
	{
		return email;
	}
	public String Password()
	{
		return password;
	}
	public String Name()
	{
		return name;
	}
	public String getDOB()
	{
		return birthdate;
	}
public String toString()
	{
		return name+email+password+gender;
	}
}
public class CreateAccount {
	static String path= "E:\\Client.dat";
    CreateAccount(String name,String email,String password,String gender,String birthdate) throws IOException, ClassNotFoundException
    { 
    	int k=0;
    	User[] user=new User[100];
    	try
    	{
    	FileInputStream fi=new FileInputStream(path);
        ObjectInputStream oi=new ObjectInputStream(fi);
       while(true)
       {
    	   try{
    		   
    	   user[k]=(User)oi.readObject();
    	   k++;
    	   }
    	   catch(EOFException e)
    	   {
    		   oi.close();
    		   fi.close();
    		   break;
    	   }
       }
    	}
    	catch(FileNotFoundException e)
    	{
    		
    	}
       
		User user1=new User(name,email,password,gender,birthdate);
		user[k]=user1;
		FileOutputStream fo=new FileOutputStream(path,false);
		ObjectOutputStream os=new ObjectOutputStream(fo);
		for(int i=0;i<=k;i++)
		{
		os.writeObject(user[i]);
		}
		os.close();

	}

}
