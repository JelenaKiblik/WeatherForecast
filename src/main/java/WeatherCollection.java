package program;

import java.io.*;

public class WeatherCollection implements Weather {

    public WeatherReport getWeather(WeatherRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            //BufferedReader reader = new BufferedReader(new FileReader(request.filename));
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jelen\\IdeaProjects\\Weather\\src\\main\\java\\forecast.txt"));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        return new WeatherReport(stringBuilder.toString(), request.getCurrentWeather());
    }

}
