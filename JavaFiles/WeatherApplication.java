import javax.swing.SwingUtilities;

//Class that Defines The Application As An Object In Which The Other Classes Define And Build This Object
public class WeatherApplication {

	//Weather Information and Airfield Information
	static Results mainResult;
	static ResultsInformation mainInfo;
	
	public WeatherApplication()
	{
		
	}
	
	//Main Class That Creates a New Instance of a Weather Application Object and Runs its Execution
	public static void main(String[]args)
	{
		WeatherApplication newOne = new WeatherApplication();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new StartScreen(newOne);
			}
		});
	}
	
	//Appropriate Getters and Setters For Weather Information and Airfield Information
	public static Results getMainResult()
	{
		return mainResult;
	}
	public static void setMainResult(Results into)
	{
		mainResult = into;
	}
	public static ResultsInformation getMainInfo()
	{
		return mainInfo;
	}
	public static void setMainInfo(ResultsInformation into)
	{
		mainInfo = into;
	}
}
