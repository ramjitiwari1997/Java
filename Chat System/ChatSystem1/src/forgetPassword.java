import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class forgetPassword {
User[] user=new User[100];
User user1;
boolean flag=false;
String path= "E:\\Server.dat";
forgetPassword(String email,String birthdate) throws IOException, ClassNotFoundException
{
	FileInputStream fi=new FileInputStream(path);
	ObjectInputStream os=new ObjectInputStream(fi);
	while(true)
	{
		try
		{
		user1=(User)os.readObject();
		if(user1.Email().equals(email)&&user1.getDOB().equals(birthdate))
		{
			flag=true;
			break;
		}
		}
		catch(EOFException e)
		{
			break;
		}
	}
	os.close();
}
public boolean cheakAccount()
{
	return flag;
}
public String getPassword()
{
	return user1.Password();
}
}
