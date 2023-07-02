
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Class To Establish Database Connection, Write SQL Statements For Information Retrieval and Using Retrieved Information For API Call
public class SelectApp {
	//Establishing Database Connection
    private Connection connect() {
        // SQLite connection string, change file path, file provided
        String url = "jdbc:sqlite:C:\\Users\\Aman\\Downloads\\GlobalAirportDatabase_SQLiteDB\\global_airports_sqlite.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    //Selecting Appropriate Airfield Information Using User Inputed ICAO Code
    public void selectAll(String userInput, WeatherApplication Within){
        String sql = "SELECT name, city, lat_deg, lat_dir, lon_deg, lon_dir, icao_code FROM airports WHERE icao_code = '" + userInput + "'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){         
       
        	// Loop Through The Result Set
            while (rs.next()) {
                double lat = rs.getDouble("lat_deg");
                double lon = rs.getDouble("lon_deg");
               WeatherApplication.setMainResult(GsonUse.weatherConditions(lat, lon));
               ResultsInformation here = new ResultsInformation(rs.getString("Name"), rs.getString("City"), rs.getString("icao_code"), rs.getDouble("lat_deg"), 
            		   rs.getString("lat_dir"), rs.getDouble("lon_deg"), rs.getString("lon_dir"));
               WeatherApplication.setMainInfo(here);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method Taking In User Inputed ICAO Code
    public static void UserInputToApp(String input, WeatherApplication Within)
    {
    	SelectApp app = new SelectApp();
        app.selectAll(input, Within);
    }

}
