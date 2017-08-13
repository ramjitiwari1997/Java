import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					welcomeScreen frame = new welcomeScreen();
					frame.setVisible(true);
					frame.setLocation(500,200);
				
	}

	/**
	 * Create the frame.
	 */
	public welcomeScreen() {
		setTitle("JAVA MESSANGER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 602, 342);
		contentPane.add(background);
		ImageIcon icon=new ImageIcon(getClass().getClassLoader().getResource("background.jpg"));
		background.setIcon(icon);
		
		JButton signup = new JButton("CREATE NEW ACCOUNT");
		signup.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		signup.setBounds(165, 11, 244, 38);
		contentPane.add(signup);
		
		JButton signin = new JButton("SIGHN IN");
		signin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		signin.setBounds(165, 74, 244, 38);
		contentPane.add(signin);
		
		JButton forgetpassword = new JButton("FORGET PASSWORD");
		forgetpassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		forgetpassword.setBounds(165, 141, 244, 38);
		contentPane.add(forgetpassword);
		
		JButton about = new JButton("ABOUT");
		about.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		about.setBounds(165, 211, 244, 38);
		contentPane.add(about);
		
		JLabel lblNewLabel = new JLabel("                                               COPYRIGHT BY QUEEN CONSOLIDATION ISO-1001554");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(0, 339, 602, 14);
		contentPane.add(lblNewLabel);
	}
}
