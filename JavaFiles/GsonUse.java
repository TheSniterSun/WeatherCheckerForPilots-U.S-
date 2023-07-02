import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.*;

//Class to Read, Parse, and Interpret JSON Response From API Call
public class GsonUse {
	
	//Unit Conversions For JSON Weather Variables From JSON Response Given From the API Call
	public static double KelvintoCelsius(double temperature)
	{
		return temperature - 273;
	}
	
	public static double MpStoKnots(double windSpeed)
	{
		return windSpeed * 1.94384449;
	}
	
	public static double MeterstoStatuteMiles(double visibility)
	{
		return visibility / 1609.344;
	}
	
	public static double HptoInchesofMercury (double pressure)
	{
		return pressure * 0.0295;
	}
	
	//Reformatting JSON Response and Reinterpreting as Java Classes
	public static Results weatherConditions(double lat, double lon)
	{
		Gson use = new Gson();
		try {
			Example test = use.fromJson(
					IOUtils.toString(new URL(ApiCall(lat, (-1 * lon)))), Example.class);
			Weather test2 = test.getCurrent().getWeather().get(0);
			Results newResult = new Results(KelvintoCelsius(test.getCurrent().getFeelsLike()), 
					MpStoKnots(test.getCurrent().getWindSpeed()), MeterstoStatuteMiles(test.getCurrent().getVisibility()), 
					HptoInchesofMercury(test.getCurrent().getPressure()), test.getCurrent().getClouds(), test2.getDescription());
			return newResult;
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//API Call
	public static String ApiCall(double lat, double lon)
	{
		return "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + 
				"&exclude=hourly,daily,minutely,alerts&appid=10acb5e83db3f4fabcddc4bc5ae9a147";
	}
	
}
