import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

//Display Screen Class For Weather Conditions
//ActionListener Interface Implemented Along With Its Methods
public class DisplayScreen implements ActionListener{

	//Screen Components
	private JTextArea area;
	private JTextArea area2;
	private JTextArea area3;
	private String together = "";
	private JButton jb = new JButton("Refresh Weather");
	private JButton jb2 = new JButton("Title Screen");
	private JButton jb3 = new JButton("Reset");
	private JButton jb4 = new JButton("Refresh Airfield");
	private int count = 0;
	private JFrame jfrm = new JFrame("Real-Time Centralized Weather Checker For Pilots (U.S Edition)");
	private JLabel jlab1 = new JLabel("Weather ", SwingConstants.RIGHT);
	private JLabel jlab2 = new JLabel("Information");
	private JLabel jlab3 = new JLabel("Airfield ", SwingConstants.RIGHT);
	private JLabel jlab4 = new JLabel("Information");
	private static WeatherApplication DisplayInstance;
	
	static JTextField t = new JTextField(); static JTextField t2 = new JTextField(); static JTextField t3 = new JTextField();
	static JTextField t4 = new JTextField(); static JTextField t5 = new JTextField(); static JTextField t6 = new JTextField();
	static JTextField tt6 = new JTextField();
	
	//Display Screen Defined Here and Built
	DisplayScreen(WeatherApplication into){
		DisplayInstance = into;
		jfrm.setSize(1100, 200);
		jfrm.setLayout(new GridLayout(1,4,0,0));
		
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpan = new JPanel(); jpan.setLayout(new GridLayout(2,1,0,0));
		
		JPanel jpan2 = new JPanel(); jpan2.setLayout(new GridLayout(2,1,0,0));
				
		jpan2.add(jlab1); jpan2.add(jlab2); jpan2.add(jb); jpan2.add(jb2); jpan.add(jlab3); jpan.add(jlab4); jpan.add(jb3); jpan.add(jb4);
		jb.addActionListener(this); jb2.addActionListener(this); jb3.addActionListener(this); jb4.addActionListener(this);
		
		JPanel testing1 = new JPanel();
		testing1.setLayout(new GridLayout(6,2,0,0));
		testing1.setSize(250,500);
		
		JLabel c = new JLabel("Temperature:"); JLabel c2 = new JLabel("Wind Speed"); 
		JLabel c3 = new JLabel("Visibility"); JLabel c4 = new JLabel("Pressure");
		JLabel c5 = new JLabel("Cloudiness"); JLabel c6 = new JLabel("Description");
		
		testing1.add(c); testing1.add(t); testing1.add(c2); testing1.add(t2); testing1.add(c3); testing1.add(t3); testing1.add(c4); testing1.add(t4);
		testing1.add(c5); testing1.add(t5); testing1.add(c6); testing1.add(t6);
	
		weatherConditionDisplayed();
		
		JScrollPane left = new JScrollPane(testing1); JScrollPane right = new JScrollPane(jpan2);
		
		JPanel testing2 = new JPanel(); testing2.setLayout(new GridLayout(6,2,0,0)); testing2.setSize(250,500);
		
		JLabel cc = new JLabel("Airfield Name:"); JLabel cc2 = new JLabel("City:"); JLabel cc3 = new JLabel("ICAO Code:");
		JLabel cc4 = new JLabel("Latitude:"); JLabel cc5 = new JLabel("Longitude:"); JLabel cc6 = new JLabel("Flying Safety Status: ");
		JTextField tt = new JTextField(), tt2 = new JTextField(), tt3 = new JTextField(), tt4 = new JTextField(), 
		tt5 = new JTextField();
		testing2.add(cc); testing2.add(tt); testing2.add(cc2); testing2.add(tt2); testing2.add(cc3); testing2.add(tt3);
		testing2.add(cc4); testing2.add(tt4); testing2.add(cc5); testing2.add(tt5); testing2.add(cc6); testing2.add(tt6);
		tt.setText(DisplayInstance.getMainInfo().getName()); tt2.setText(DisplayInstance.getMainInfo().getCity()); tt3.setText(DisplayInstance.getMainInfo().getIACOcode());
		tt4.setText(DisplayInstance.getMainInfo().getLatitude()); tt5.setText(DisplayInstance.getMainInfo().getLongitude());
		SafetyCheck();
		
		JScrollPane left2 = new JScrollPane(jpan); JScrollPane right2 = new JScrollPane(testing2);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left2, right2);
		jfrm.getContentPane().add(split); jfrm.getContentPane().add(split2);
	
		try {
			jfrm.setIconImage(ImageIO.read(new File("C:\\\\Users\\\\Aman\\\\Downloads\\\\safetyInternalicon.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Function to Display Weather Conditions on Screen
	public void weatherConditionDisplayed()
	{
		String temperature = String.format("%.2f", DisplayInstance.getMainResult().getResultTemperature());
		temperature += " °C";
		t.setText(temperature);
		String windSpeed = String.format("%.2f", DisplayInstance.getMainResult().getResultWindSpeed());
		windSpeed += " Knots";
		t2.setText(windSpeed);
		String visibility = String.format("%.2f", DisplayInstance.getMainResult().getResultVisibility());
		visibility += " Statute Miles";
		t3.setText(visibility);
		String pressure = String.format("%.2f", DisplayInstance.getMainResult().getResultPressure());
		pressure += " Inches of Mercury";
		t4.setText(pressure);
		String cloudiness = String.format("%.2f", DisplayInstance.getMainResult().getResultCloudiness());
		cloudiness += "% Cloudy";
		t5.setText(cloudiness);
		String description = DisplayInstance.getMainResult().getResultDescription();
		t6.setText(description);
	}
	
	//Refresh Button Function To Retrieve Current Weather Conditions
	public void RefreshWeatherButton()
	{
		int latNumConverted = Integer.valueOf(DisplayInstance.getMainInfo().getLatitude().substring(0, 2));
		int lonNumConverted = Integer.valueOf(DisplayInstance.getMainInfo().getLongitude().substring(0, 2));
		DisplayInstance.setMainResult(GsonUse.weatherConditions(latNumConverted, lonNumConverted));
		weatherConditionDisplayed();
	}
	
	//Function For Safety Evaluation
	public void SafetyCheck()
	{
		if(DisplayInstance.getMainResult().getResultTemperature() >= -5 && DisplayInstance.getMainResult().getResultTemperature() <= 35
				&&  DisplayInstance.getMainResult().getResultWindSpeed() <= 15 && DisplayInstance.getMainResult().getResultVisibility() >= 3)
		{
			tt6.setText("SAFE");
		} else {
			String SafetyFailed = "UNSAFE!: ";
			if(DisplayInstance.getMainResult().getResultTemperature() < -5)
			{
				SafetyFailed += "Temperature too low. ";
			}
			if(DisplayInstance.getMainResult().getResultTemperature() > 35)
			{
				SafetyFailed += "Temperature too high. ";
			}
			if(DisplayInstance.getMainResult().getResultWindSpeed() > 15)
			{
				SafetyFailed += "Wind speed too strong. ";
			}
			if(DisplayInstance.getMainResult().getResultVisibility() < 3)
			{
				SafetyFailed += "Visibility too low. ";
			}
			if(DisplayInstance.getMainResult().getResultDescription().contains("rain"))
			{
				SafetyFailed += "Rain is present. ";
			}
			if(DisplayInstance.getMainResult().getResultDescription().contains("snow"))
			{
				SafetyFailed += "Snow is present. ";
			}
			tt6.setText(SafetyFailed);
		}
	}
	
	//Functionality For All Button Interactions on The Screen
	@Override
	public void actionPerformed(ActionEvent e) {
		//Title Screen Button
		if(e.getActionCommand() == "Title Screen")
		{
			jfrm.setVisible(false);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new StartScreen(DisplayInstance);
				}
			});
		}
		//Reset Button
		if(e.getActionCommand() == "Reset")
		{
			jfrm.setVisible(false);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new SearchScreen(DisplayInstance);
				}
			});
		}
		//Refresh Button For Weather
		if(e.getActionCommand() == "Refresh Weather")
		{
			RefreshWeatherButton();
		}
		//Refresh Button For Airfield
		if(e.getActionCommand() == "Refresh Airfield")
		{
			RefreshWeatherButton();
			SafetyCheck();
		}
	}
	
}

