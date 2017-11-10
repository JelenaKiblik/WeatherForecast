import weatherProgram.WeatherCollection;
import dataParser.DataExtractor;
import weatherProgram.WeatherReport;
import weatherProgram.WeatherRequest;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherRequest request = new WeatherRequest("Tallinn", "EE");
        WeatherCollection collection = new WeatherCollection();
        collection.getWeather(request);
        WeatherReport report = collection.getWeather(request);
        System.out.println(report.getLongitude());
        System.out.println(report.getLatitude());

    }
}