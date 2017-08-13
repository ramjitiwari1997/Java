import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SignIn {
	boolean flag=false;
	boolean flagEmail=false;
	int k=0;
      User[] user=new User[100];
      User user1;
	 SignIn(String email,String password) throws IOException, ClassNotFoundException
	{  
		 String path= "E:\\Server.dat";
		 FileInputStream fi=new FileInputStream(path);
		 ObjectInputStream oi=new ObjectInputStream(fi);
		 while(true)
		 {
			 try
			 {
				 user1 =(User)oi.readObject();
				 System.out.println(user1.Email());
				 if(email.equals(user1.Email())&&password.equals(user1.Password()))
				 {
					 emailSet(true);
					 passwordSet(true);
					 break;
				 }
			 }
			 catch(EOFException e)
			 {
				 break;
			 }
		 }
				oi.close();
				fi.close();
			}
		
	 public void emailSet(boolean flagEmail)
	 {
		 this.flagEmail=flagEmail;
	 }
	 public void passwordSet(boolean flag)
	 {
		 this.flag=flag;

	 }
	 public boolean emailGet()
	 {
		 return flagEmail;
	 }
	 public boolean passwordGet()
	 {
		 return flag;
	 }
	 public String getName()
	 {
		 return user1.Name();
	 }
}
