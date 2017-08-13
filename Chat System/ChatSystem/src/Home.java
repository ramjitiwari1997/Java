import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private static JDesktopPane desktopPane_1=null ;
	private JTextField textField;
	private JPasswordField confermpasswordField;
	private JPasswordField passwordField;
	private JTextField emailfield;
	private JPasswordField passwordField_1;
	private static JDesktopPane signinpane=null;
	 static Home frame;
	static JTextField messageField;
	static ServerSocket server;
	static DataInputStream in;
	static DataOutputStream out;
	static SignIn cheak=null;
	private static JDesktopPane chatpane=null;
	static JTextArea messagePrint = new JTextArea();
	private static JLabel background1 = new JLabel("");
	private JButton changepassword = new JButton("CHANGE PASSWORD");
	ActionListener action=null;
	private static JDesktopPane aboutusPane=null;
	private static JDesktopPane changepasswordpane=null;
	private JTextField getemail;
	private  static int PORT=9001;
	ImageIcon icon1=new ImageIcon(getClass().getClassLoader().getResource("background1.jpg"));
	ImageIcon icon2=new ImageIcon(getClass().getClassLoader().getResource("background4.png"));
	private static JDesktopPane forgetPasswordPane=null;
	private JTextField dobfield;
	private JTextField mailfield;
	private JTextField birthdayfield;
	private forgetPassword fp=null;
	private JLabel connection;
	private Socket socket;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		frame=null;
					frame = new Home();
					frame.setVisible(true);
					String IP=JOptionPane.showInputDialog(frame,"ENTER SERVER IP ADDRESS","localhost");
					System.out.println(IP);
					try
					{
						frame.InitilizeServer(PORT,IP);
				    frame.recieveMessage();
					}
					catch(SocketException e)
					{
						JOptionPane.showMessageDialog(frame, "SERVER NOT FOUND");
						frame.dispose();
					}
				   
	}

	/**
	 * Create the frame.
	 */
	public Home() {
	   this.setTitle(" CHAT SYSTEM");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 222, 433);
		contentPane.add(desktopPane);
		ImageIcon icon=new ImageIcon(getClass().getClassLoader().getResource("background.jpg"));
		JButton signup = new JButton("CREATE NEW ACCOUNT");
			
		
		signup.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		signup.setBounds(0, 0, 222, 43);
		desktopPane.add(signup);
		JButton signin = new JButton("SIGN IN");
		
		
		signin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		signin.setBounds(0, 64, 222, 43);
		desktopPane.add(signin);
		
		
		changepassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		changepassword.setBounds(0, 134, 222, 43);
		desktopPane.add(changepassword);
		changepassword.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						allClear();
						ChangePassword();
					}	
				});
		
		JButton forgetpassword = new JButton("FORGET PASSWORD");
		forgetpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allClear();
				ForgetPassword();
			}
		});
		forgetpassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		forgetpassword.setBounds(0, 206, 222, 43);
		desktopPane.add(forgetpassword);
	
		
		JButton update = new JButton("CHECK FOR UPDATE");
		update.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		update.setBounds(0, 285, 222, 43);
		desktopPane.add(update);
		update.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(frame, "SOFTWARE IS UP TO DATE\nversion-:1.0000");
					}
			
				});
		
		JButton about = new JButton("ABOUT US");
		about.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		about.setBounds(0, 362, 222, 43);
		desktopPane.add(about);
		about.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						allClear();
						AboutUs();
					}
			
				});
		
		
		
		JLabel menu = new JLabel("");
		menu.setBounds(0, 0, 222, 433);
		desktopPane.add(menu);
		menu.setIcon(icon);
		
		
	    
		
		
		 background1.setBounds(225, 0, 479, 433);
		 contentPane.add(background1);
	     background1.setIcon(icon1);

		
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClear();
				createAccount();
			}
		});
		
		
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allClear();
				if(chatpane!=null)
				{
					chatpane.setVisible(true);
				}
				else if(chatpane==null)
				{
					//allClear();
				try {
					signin();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			}
		});	
		
		
		
				
		
				 
				}
	
	public static void allClear()
	{
			if(signinpane!=null)
			{
				signinpane.setVisible(false);
			signinpane.removeAll();
			}
			if(desktopPane_1!=null)
			{
				desktopPane_1.setVisible(false);
				desktopPane_1.removeAll();
			}
			if(chatpane!=null)
			{
				chatpane.setVisible(false);
				//chatpane.removeAll();
			}
			if(aboutusPane!=null)
			{
				aboutusPane.setVisible(false);
			}
			if(changepasswordpane!=null)
			{
				changepasswordpane.setVisible(false);
				changepasswordpane.removeAll();
			}
			if(forgetPasswordPane!=null)
			{
				forgetPasswordPane.setVisible(false);
				//forgetPasswordPane.removeAll();
			}
			background1.setVisible(false);
	}
	void createAccount()
	{
		
		
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.WHITE);
		desktopPane_1.setBounds(221, 0, 473, 433);
		contentPane.add(desktopPane_1);
		
		JLabel title = new JLabel("         CREATE YOUR ACCOUNT");
		title.setBackground(Color.WHITE);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setBounds(87, 21, 333, 30);
		desktopPane_1.add(title);
		
		JLabel name = new JLabel("          NAME");
		name.setBackground(Color.LIGHT_GRAY);
		name.setForeground(Color.BLUE);
		name.setFont(new Font("Tahoma", Font.BOLD, 18));
		name.setBounds(10, 62, 155, 38);
		desktopPane_1.add(name);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setForeground(Color.BLACK);
		nameField.setBounds(200, 70, 273, 30);
		desktopPane_1.add(nameField);
		nameField.setColumns(10);
		
		JLabel email = new JLabel("   EMAIL ID");
		email.setForeground(Color.BLUE);
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.BOLD, 18));
		email.setBounds(10, 111, 155, 38);
		desktopPane_1.add(email);
		
		textField = new JTextField();
		textField.setBounds(200, 119, 273, 30);
		desktopPane_1.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Thoma",Font.PLAIN,18));
		
		JLabel gender = new JLabel("     GENDER");
		gender.setBackground(Color.WHITE);
		gender.setFont(new Font("Tahoma", Font.BOLD, 18));
		gender.setForeground(Color.BLUE);
		gender.setBounds(10, 225, 155, 38);
		desktopPane_1.add(gender);
		
		JRadioButton male = new JRadioButton("MALE");
		male.setBackground(Color.WHITE);
		male.setForeground(Color.BLUE);
		male.setFont(new Font("Tahoma", Font.BOLD, 14));
		male.setBounds(192, 225, 93, 38);
		desktopPane_1.add(male);
		
		JRadioButton female = new JRadioButton("FEMALE");
		female.setForeground(Color.BLUE);
		female.setFont(new Font("Tahoma", Font.BOLD, 14));
		female.setBackground(Color.WHITE);
		female.setBounds(311, 225, 109, 38);
		desktopPane_1.add(female);
		
		JButton cancle = new JButton("CANCEL");
		cancle.setForeground(Color.RED);
		cancle.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancle.setBounds(10, 386, 127, 36);
		desktopPane_1.add(cancle);
		
		JButton submit = new JButton("SUBMIT");
		submit.setForeground(Color.RED);
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBounds(319, 386, 127, 36);
		desktopPane_1.add(submit);
		
		JLabel password = new JLabel("  PASSWORD");
		password.setForeground(Color.BLUE);
		password.setFont(new Font("Tahoma", Font.BOLD, 18));
		password.setBackground(Color.WHITE);
		password.setBounds(10, 286, 155, 30);
		desktopPane_1.add(password);
		
		JLabel confermpasswordfield = new JLabel("CONFERM PASSWORD");
		confermpasswordfield.setForeground(Color.BLUE);
		confermpasswordfield.setBackground(Color.WHITE);
		confermpasswordfield.setFont(new Font("Tahoma", Font.BOLD, 18));
		confermpasswordfield.setBounds(10, 337, 223, 38);
		desktopPane_1.add(confermpasswordfield);
		
		confermpasswordField = new JPasswordField();
		confermpasswordField.setBounds(240, 337, 233, 30);
		desktopPane_1.add(confermpasswordField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 286, 233, 30);
		desktopPane_1.add(passwordField);
		
		
		ButtonGroup group=new ButtonGroup();
		group.add(male);
		group.add(female);
		
		JLabel dob = new JLabel("DATE OF BIRTH");
		dob.setForeground(Color.BLUE);
		dob.setFont(new Font("Tahoma", Font.BOLD, 18));
		dob.setBounds(10, 181, 155, 33);
		desktopPane_1.add(dob);
		
		dobfield = new JTextField();
		dobfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dobfield.setToolTipText("DD/MM/YYYY");
		dobfield.setBounds(199, 181, 155, 29);
		desktopPane_1.add(dobfield);
		dobfield.setColumns(10);
		ButtonModel buttonmodel=group.getSelection();
	 	
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=nameField.getText();
				String email=textField.getText();
				char[] password=passwordField.getPassword();
				String password1=new String(password);
				char[] confermpassword=confermpasswordField.getPassword();
				String confermpassword1=new String(confermpassword);
				String gender=null;	
				String birthdate=dobfield.getText();
				if(male.isSelected())
				{
					gender="male";
				}
				else if(female.isSelected())
				{
					gender="female";
				}
				if(name==null||email==null||group.isSelected(buttonmodel)!=false)
				{
					JOptionPane.showMessageDialog(frame,"PLEASE FILL  ALL FIELDS");
				}
				else if(password1.equals(confermpassword1)==false)
				{
					JOptionPane.showMessageDialog(frame,"PASSWORD DID NOT MATCHED");
				}
				else if(birthdate.equals(null)||birthdate.equals("DD/MM/YYYY"))
				{
					JOptionPane.showMessageDialog(frame,"PLEASE ENTER DATE OF BIRTH");
				}
				else if(birthdate.length()>10||birthdate.length()<10)
				{
					JOptionPane.showMessageDialog(frame,"PLEASE ENTER THE DATE OF BIRTH IN CORRECT FORMATE");
				}
				else
				{
					
					try {
						new CreateAccount(name,email,password1,gender,birthdate);
						JOptionPane.showMessageDialog(frame,"ACCOUNT CREATED");
						desktopPane_1.setVisible(false);
						background1.setVisible(true);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});	
		cancle.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				allClear();
				background1.setVisible(true);
				
			}});
		
				
			
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 467, 433);
		desktopPane_1.add(label);
		label.setIcon(icon2);
		
		
		
	}
	void signin() throws IOException
	{
		
		signinpane = new JDesktopPane();
		signinpane.setBackground(Color.WHITE);
		signinpane.setBounds(228, 0, 466, 433);
		contentPane.add(signinpane);
		
		JLabel signintitle = new JLabel("     SIGN IN TO YOUR ACCOUNT");
		signintitle.setForeground(new Color(0, 0, 205));
		signintitle.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		signintitle.setBackground(Color.WHITE);
		signintitle.setBounds(34, 38, 355, 46);
		signinpane.add(signintitle);
		
		JLabel email = new JLabel("EMAIL ID-:");
		email.setForeground(new Color(0, 100, 0));
		email.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		email.setBackground(Color.WHITE);
		email.setBounds(0, 159, 133, 37);
		signinpane.add(email);
		
		emailfield = new JTextField();
		emailfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailfield.setBounds(143, 169, 313, 20);
		signinpane.add(emailfield);
		emailfield.setColumns(10);
		
		JLabel password = new JLabel("PASSWORD-:");
		password.setBackground(Color.WHITE);
		password.setForeground(new Color(0, 100, 0));
		password.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		password.setBounds(0, 252, 133, 37);
		signinpane.add(password);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(143, 262, 313, 20);
		signinpane.add(passwordField_1);
		
		JButton submitbutton = new JButton("SUBMIT");
		submitbutton.setForeground(new Color(0, 100, 0));
		submitbutton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		submitbutton.setBounds(338, 356, 118, 37);
		signinpane.add(submitbutton);
		
		JButton canclebutton = new JButton("CANCEL");
		canclebutton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		canclebutton.setForeground(new Color(0, 100, 0));
		canclebutton.setBounds(33, 356, 118, 37);
		signinpane.add(canclebutton);
		
		
		canclebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allClear();
				background1.setVisible(true);
			}
		});
		
		
		submitbutton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
					String email=emailfield.getText();
					char[] password=passwordField_1.getPassword();
					String password1=new String(password);
					try {
						 cheak=new SignIn(email,password1);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//String status=cheak.Incorrect();
					if(cheak.emailGet()==false)
					{
						JOptionPane.showMessageDialog(frame,"USER NOT FOUND");	
					}
					else if(cheak.passwordGet()==false)
					{
						JOptionPane.showMessageDialog(frame,"YOU HAVE ENTERED INCORRECT PASSWORD");
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"VALID USER LOGIN");
						 frame.setTitle("CHAT SYSTEM                                                                WELCOME TO  "+cheak.getName().toUpperCase());
						//ServerChat();
						try {
							allClear();
					
							ServerChat();
							
							//recieveMessage();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					}
					
				});
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 467, 433);
		signinpane.add(label);
		label.setIcon(icon2);
		
	}	
	public void ServerChat()
	{
		chatpane = new JDesktopPane();
		chatpane.setBackground(Color.WHITE);
		chatpane.setBounds(224, 0, 480, 433);
		contentPane.add(chatpane);
		
		messageField = new JTextField();
		messageField.setFont(new Font("Tahoma", Font.BOLD, 15));
		messageField.setBounds(0, 400, 324, 33);
		chatpane.add(messageField);
		messageField.setColumns(10);
		
		JButton sendButton = new JButton("SEND");
		sendButton.setForeground(Color.BLUE);
		sendButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		sendButton.setBounds(359, 400, 111, 33);
		chatpane.add(sendButton);
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBorder(new LineBorder(new Color(0,0,255),3,true));
		scrollpane.setBounds(10,56,460,333);
		chatpane.add(scrollpane);
		scrollpane.setViewportView(messagePrint);
		messagePrint.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JButton logoutbutton = new JButton("LOGOUT");
		logoutbutton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		logoutbutton.setForeground(Color.BLUE);
		logoutbutton.setBounds(346, 11, 124, 33);
		chatpane.add(logoutbutton);
		logoutbutton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						
						frame.setVisible(false);
						
					}
			
				});
		
		 connection = new JLabel(" CONNECTED");
		connection.setFont(new Font("Tahoma", Font.BOLD, 18));
		connection.setForeground(Color.BLUE);
		connection.setBounds(10, 11, 314, 34);
		chatpane.add(connection);
		 
		 sendButton.addActionListener(new ActionListener()
				 {
			 public void actionPerformed(ActionEvent e)
			 {
				sendMessage();
				messageField.setText("");
			 }
				 });
		 sendButton.addKeyListener(new KeyListener()
				 {

					@Override
					public void keyPressed(KeyEvent e) {

                       if(e.getKeyCode()==10)
                       {
                    	   sendMessage();
                    	   messageField.setText("");
                       }
						
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

			 
				 });
		 
	
		
	
	}
	void AboutUs()
	{
		
		 aboutusPane = new JDesktopPane();
			aboutusPane.setBackground(Color.WHITE);
			aboutusPane.setBounds(223, 0, 481, 433);
			contentPane.add(aboutusPane);
			ImageIcon icon3=new ImageIcon(getClass().getClassLoader().getResource("aboutus.jpg"));

			
			JButton okbutton = new JButton("OK");
			okbutton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
			okbutton.setBounds(386, 402, 95, 31);
			aboutusPane.add(okbutton);
			okbutton.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							allClear();
							background1.setVisible(true);
						}
				
					});
			
			JLabel aboutusLabel = new JLabel("");
			aboutusLabel.setBounds(0, 0, 481, 433);
			aboutusPane.add(aboutusLabel);
			aboutusLabel.setIcon(icon3);
	}
	public void ChangePassword()
	{
		changepasswordpane = new JDesktopPane();
		changepasswordpane.setBackground(Color.WHITE);
		changepasswordpane.setBounds(224, 0, 480, 433);
		contentPane.add(changepasswordpane);
		
		JLabel lblNewLabel = new JLabel("   CHANGE YOUR PASSWORD");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(0, 11, 470, 51);
		changepasswordpane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OLD PASSWORD-:");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.blue);
		lblNewLabel_1.setBounds(10, 187, 164, 42);
		changepasswordpane.add(lblNewLabel_1);
		
		JPasswordField oldpasswordfield = new JPasswordField();
		oldpasswordfield.setBounds(184, 193, 286, 26);
		changepasswordpane.add(oldpasswordfield);
		
		JLabel lblNewLabel_2 = new JLabel("NEW PASSWORD-:");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.blue);
		lblNewLabel_2.setBounds(10, 258, 164, 42);
		changepasswordpane.add(lblNewLabel_2);
		
		JPasswordField newpasswordfield = new JPasswordField();
		newpasswordfield.setBounds(184, 266, 286, 26);
		changepasswordpane.add(newpasswordfield);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setForeground(new Color(0, 0, 255));
		cancel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		cancel.setBounds(10, 339, 129, 42);
		changepasswordpane.add(cancel);
		
		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		submit.setForeground(Color.blue);
		submit.setBounds(341, 339, 129, 42);
		changepasswordpane.add(submit);
		
		JLabel emaillabel = new JLabel("ENTER EMAIL-:");
		emaillabel.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 18));
		emaillabel.setForeground(Color.blue);
		emaillabel.setBounds(10, 122, 164, 42);
		changepasswordpane.add(emaillabel);
		
		getemail = new JTextField();
		getemail.setBounds(184, 131, 286, 26);
		changepasswordpane.add(getemail);
		getemail.setColumns(10);
		
		
		
		submit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						String email=getemail.getText();
						try {
							changePassword cp=new changePassword(email);
							if(cp.getEmail())
							{
								String oldpas=oldpasswordfield.getText();
								if(cp.oldPassword(oldpas))
								{
									String newpas=newpasswordfield.getText();
									if(newpas==null||newpas==""||newpas.equals("")||newpas.equals(null))
									{
										JOptionPane.showMessageDialog(frame,"PASSWORD CAN NOT BE EMPTY");
									}
									else
									{
										cp.setPassword(newpas);
										JOptionPane.showMessageDialog(frame, "PASSWORD CHANGED SUCCESSFULLY");
										allClear();
										background1.setVisible(true);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(frame, "YOU HAVE ENTERED WRONG OLD PASSWORD");
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(frame,"ACCOUNT DID NOT FOUND");
							}
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frame, "NO ACCOUNT FOUND");
						}
						
					}
			
				});
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 467, 433);
		changepasswordpane.add(label);
		label.setIcon(icon2);
			
		
	}
	
	
	
	public void ForgetPassword()
	{
		
		 forgetPasswordPane = new JDesktopPane();
			forgetPasswordPane.setBackground(Color.WHITE);
			forgetPasswordPane.setBounds(227, 0, 467, 433);
			contentPane.add(forgetPasswordPane);
			
			JLabel title = new JLabel("PASSWORD RECOVERY");
			title.setForeground(Color.RED);
			title.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			title.setBounds(85, 0, 261, 47);
			forgetPasswordPane.add(title);
			
			JLabel mailLabel = new JLabel("ENTER YOUR EMAIL-:");
			mailLabel.setForeground(Color.RED);
			mailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			mailLabel.setBounds(21, 111, 164, 41);
			forgetPasswordPane.add(mailLabel);
			
			mailfield = new JTextField();
			mailfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mailfield.setBounds(212, 117, 245, 27);
			forgetPasswordPane.add(mailfield);
			mailfield.setColumns(10);
			
			JLabel birth = new JLabel("      DATE OF BIRTH-:");
			birth.setForeground(Color.RED);
			birth.setFont(new Font("Tahoma", Font.BOLD, 14));
			birth.setBounds(21, 211, 164, 41);
			forgetPasswordPane.add(birth);
			
			birthdayfield = new JTextField();
			birthdayfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
			birthdayfield.setForeground(Color.BLACK);
			birthdayfield.setToolTipText("DD/MM/YYYY");
			birthdayfield.setBounds(212, 211, 157, 32);
			forgetPasswordPane.add(birthdayfield);
			birthdayfield.setColumns(10);
			
			JButton okbutton = new JButton("OK");
			okbutton.setForeground(Color.BLUE);
			okbutton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
			okbutton.setBounds(331, 362, 111, 32);
			forgetPasswordPane.add(okbutton);
			okbutton.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String email=mailfield.getText();
							String dob=birthdayfield.getText();
							
							try {
								 fp=new forgetPassword(email,dob);
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(frame, "CAN NOT RECOVER");
							}
							if(fp.cheakAccount())
							{
								JOptionPane.showMessageDialog(frame, "YOUR PASSWORD IS-: "+fp.getPassword());
								allClear();
								background1.setVisible(true);
							}
							else
							{
								JOptionPane.showMessageDialog(frame, "ACCOUNT NOT FOUND");
							}
						}
				
					});
			
			JButton cancel = new JButton("CANCEL");
			cancel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
			cancel.setForeground(Color.BLUE);
			cancel.setBounds(40, 362, 111, 32);
			forgetPasswordPane.add(cancel);
			
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 467, 433);
			forgetPasswordPane.add(label);
			label.setIcon(icon2);
			cancel.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) {
							allClear();
							background1.setVisible(true);
							
						}
				
					});		
		
			
	}
	 void InitilizeServer(int port,String IP) throws IOException
		{
		 socket=new Socket(IP,PORT);
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
		}
		public void recieveMessage() throws IOException
		{
			String messageRecieved="";
			while(!messageRecieved.equalsIgnoreCase("exit"))
			{
				messageRecieved=in.readUTF();
				String string=messagePrint.getText();
				messagePrint.setText(string+"\n\n"+messageRecieved);
			}
		
			
		}
		public void sendMessage()
		{
			String messageSend=Home.messageField.getText();
			if(messageSend.equals(""))
			{
			}
			else
			{
			try {
				out.writeUTF(cheak.getName()+"::-"+messageSend);
				messagePrint.setText(messagePrint.getText()+"\n\n"+"YOU-:: "+messageSend);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(Home.frame,"WAIT FOR CONNECTION");
			}
			}
		}
	}

