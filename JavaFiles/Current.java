import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Weather Variables That Hold The Most Current Values Retrieved From the User
//Appropriate Getters and Setters
public class Current {

@SerializedName("dt")
@Expose
private Integer dt;
@SerializedName("sunrise")
@Expose
private Integer sunrise;
@SerializedName("sunset")
@Expose
private Integer sunset;
@SerializedName("temp")
@Expose
private Double temp;
@SerializedName("feels_like")
@Expose
private Double feelsLike;
@SerializedName("pressure")
@Expose
private Double pressure;
@SerializedName("humidity")
@Expose
private Double humidity;
@SerializedName("dew_point")
@Expose
private Double dewPoint;
@SerializedName("uvi")
@Expose
private Double uvi;
@SerializedName("clouds")
@Expose
private Double clouds;
@SerializedName("visibility")
@Expose
private Double visibility;
@SerializedName("wind_speed")
@Expose
private Double windSpeed;
@SerializedName("wind_deg")
@Expose
private Integer windDeg;
@SerializedName("wind_gust")
@Expose
private Double windGust;
@SerializedName("weather")
@Expose
private List<Weather> weather = null;

public Integer getDt() {
return dt;
}

public void setDt(Integer dt) {
this.dt = dt;
}

public Integer getSunrise() {
return sunrise;
}

public void setSunrise(Integer sunrise) {
this.sunrise = sunrise;
}

public Integer getSunset() {
return sunset;
}

public void setSunset(Integer sunset) {
this.sunset = sunset;
}

public Double getTemp() {
return temp;
}

public void setTemp(Double temp) {
this.temp = temp;
}

public Double getFeelsLike() {
return feelsLike;
}

public void setFeelsLike(Double feelsLike) {
this.feelsLike = feelsLike;
}

public Double getPressure() {
return pressure;
}

public void setPressure(Double pressure) {
this.pressure = pressure;
}

public Double getHumidity() {
return humidity;
}

public void setHumidity(Double humidity) {
this.humidity = humidity;
}

public Double getDewPoint() {
return dewPoint;
}

public void setDewPoint(Double dewPoint) {
this.dewPoint = dewPoint;
}

public Double getUvi() {
return uvi;
}

public void setUvi(Double uvi) {
this.uvi = uvi;
}

public Double getClouds() {
return clouds;
}

public void setClouds(Double clouds) {
this.clouds = clouds;
}

public Double getVisibility() {
return visibility;
}

public void setVisibility(Double visibility) {
this.visibility = visibility;
}

public Double getWindSpeed() {
return windSpeed;
}

public void setWindSpeed(Double windSpeed) {
this.windSpeed = windSpeed;
}

public Integer getWindDeg() {
return windDeg;
}

public void setWindDeg(Integer windDeg) {
this.windDeg = windDeg;
}

public Double getWindGust() {
return windGust;
}

public void setWindGust(Double windGust) {
this.windGust = windGust;
}

public List<Weather> getWeather() {
return weather;
}

public void setWeather(List<Weather> weather) {
this.weather = weather;
}

}