//Java Class Interpretation of the JSON Response Given by the API Call
public class Results {

	private double ResultTemperature; private double ResultWindSpeed; private double ResultVisibility; private double ResultPressure; private double ResultCloudiness; private String ResultDescription;
	
	Results(double ResultTemperature, double ResultWindSpeed, double ResultVisibility, double ResultPressure, double ResultCloudiness, String ResultDescription)
	{
		this.ResultTemperature = ResultTemperature; this.ResultWindSpeed = ResultWindSpeed; this.ResultVisibility = ResultVisibility; this.ResultPressure = ResultPressure; this.ResultCloudiness = ResultCloudiness; this.ResultDescription = ResultDescription;
	}

	public double getResultTemperature() {
		return ResultTemperature;
	}

	public void setResultTemperature(int resultTemperature) {
		ResultTemperature = resultTemperature;
	}

	public double getResultWindSpeed() {
		return ResultWindSpeed;
	}

	public void setResultWindSpeed(int resultWindSpeed) {
		ResultWindSpeed = resultWindSpeed;
	}

	public double getResultVisibility() {
		return ResultVisibility;
	}

	public void setResultVisibility(int resultVisibility) {
		ResultVisibility = resultVisibility;
	}

	public double getResultPressure() {
		return ResultPressure;
	}

	public void setResultPressure(int resultPressure) {
		ResultPressure = resultPressure;
	}

	public double getResultCloudiness() {
		return ResultCloudiness;
	}

	public void setResultCloudiness(int resultCloudiness) {
		ResultCloudiness = resultCloudiness;
	}

	public String getResultDescription() {
		return ResultDescription;
	}

	public void setResultDescription(String resultDescription) {
		ResultDescription = resultDescription;
	}
	
}
