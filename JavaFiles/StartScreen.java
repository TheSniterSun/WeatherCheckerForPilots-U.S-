import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
//Start Screen Class For the Application. User Can Click or Press Enter to Begin Using the Application
//ActionListener and KeyListener Interfaces Implemented Along With Their Respective Methods
public class StartScreen implements ActionListener, KeyListener{

	//Screen Components
	private JLabel lab1= new JLabel("Safe Flying", SwingConstants.CENTER);
	private JButton but1 = new JButton("Start");
	private JFrame jfrm = new JFrame("Real-Time Centralized Weather Checker For Pilots (U.S Edition)");
	private static WeatherApplication StartInstance;
	
	//Start Screen Defined Here and Built
	public StartScreen(WeatherApplication into) {
		jfrm.setSize(400, 200);
		jfrm.setLayout(new GridLayout(2,1,0,0));
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.add(lab1);
		jfrm.add(but1);
		but1.addActionListener((ActionListener) this);
		jfrm.addKeyListener(this);
		StartInstance = into;
		jfrm.getRootPane().setDefaultButton(but1);
		try {
			//Change file path, image provided
			jfrm.setIconImage(ImageIO.read(new File("C:\\\\Users\\\\Aman\\\\Downloads\\\\safetyInternalicon.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Button Functionality For Start Button For Clicking
	public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new SearchScreen(StartInstance);
				}
			});
			jfrm.setVisible(false);
		}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	//Button Functionality For Start Button For Pressing Enter
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new SearchScreen(StartInstance);
				}
			});
			jfrm.setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}	
}
