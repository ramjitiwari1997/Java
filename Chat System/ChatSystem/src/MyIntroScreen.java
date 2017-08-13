import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
public class MyIntroScreen extends JWindow{
/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
private JPanel contentpane;
	public static void main(String...ss)
	{
	MyIntroScreen frame=new MyIntroScreen();
	frame.setVisible(true);
	}
	public MyIntroScreen() {
		setBackground(new Color(65, 105, 225));
contentpane=new JPanel();
contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentpane.setBackground(new Color(0, 255, 255));
setContentPane(contentpane);
contentpane.setLayout(null);
JLabel photo = new JLabel("");
ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("giphy.gif"));
photo.setBounds(51, 105, 340, 167);
photo.setIcon(icon);
contentpane.add(photo);

	}
}
