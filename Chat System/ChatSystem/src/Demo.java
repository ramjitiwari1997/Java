import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Container;

public class Demo extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Demo frame = new Demo();
					frame.setVisible(true);
					frame.setLocation(500,300);
	}

	/**
	 * Create the frame.
	 */
	public Demo() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel photo = new JLabel("");
		photo.setBounds(0, 0, 400, 300);
		contentPane.add(photo);
		//ImageIcon icon=new ImageIcon(getClass().getClassLoader().getResource("photo.gif"));
		//photo.setIcon(icon);
		

	}
}
