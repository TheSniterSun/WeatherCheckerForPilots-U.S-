import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
//Search Screen Class For User to Input ICAO Code of Desired Airfield
//ActionListener and KeyListener Interfaces Implemented Along With Their Respective Methods
public class SearchScreen implements ActionListener, KeyListener{

	//Screen Components
	private JLabel lab1= new JLabel("Input ICAO Code", SwingConstants.CENTER);
	private JTextField tex1 = new JTextField();
	private JButton but1 = new JButton("Search");
	JFrame jfrm = new JFrame("Real-Time Centralized Weather Checker For Pilots (U.S Edition)");
	private static WeatherApplication SearchInstance;
	
	//Search Screen Defined Here and Built
	public SearchScreen(WeatherApplication into) {
		jfrm.setSize(400, 200);
		jfrm.setLayout(new GridLayout(3,1,0,0));
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		but1.addActionListener((ActionListener) this);
		jfrm.add(lab1);
		jfrm.add(tex1);
		jfrm.add(but1);
		jfrm.getRootPane().setDefaultButton(but1);
		jfrm.addKeyListener(this);
		SearchInstance = into;
		
		try {
			jfrm.setIconImage(ImageIO.read(new File("C:\\\\Users\\\\Aman\\\\Downloads\\\\safetyInternalicon.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Functionality For All Button Interactions on the Screen
	@Override
	public void actionPerformed(ActionEvent e) {
		//Search Button Click Functionality
		SelectApp.UserInputToApp(tex1.getText(), SearchInstance);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DisplayScreen(SearchInstance);
			}
		});
		jfrm.setVisible(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	//Functionality For Pressing Enter Key
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new SearchScreen(SearchInstance);
				}
			});
			jfrm.setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
}
