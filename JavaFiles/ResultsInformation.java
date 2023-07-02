// Class Information For Name, City, ICAO Code, Latitude, Longitude That Will Be Retrieved By SQL SELECT Statements
public class ResultsInformation {

	//Variables For Name, City, ICAO Code, Latitude, Longitude
	private String name;
	private String city;
	private String IACOcode;
	private String latitude;
	private String longitude;
	
	ResultsInformation(String name, String city, String IACOcode, double latitudeNumber, String latDir, double longitudeNumber, String lonDir)
	{
		this.name = name;
		this.city = city;
		this.IACOcode = IACOcode;
		this.latitude = latitudeNumber + "° " + latDir;
		this.longitude = longitudeNumber + "° " + lonDir;
	}

	//Appropriate Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIACOcode() {
		return IACOcode;
	}

	public void setIACOcode(String iACOcode) {
		IACOcode = iACOcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
