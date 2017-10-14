package java;

/*
 * This class holds just the specifications of the request.
 */
public class WeatherRequest {

    private final String CITY;
    private final String COUNTRY_ALPHA_CODE;
    private final String TEMP;


    public WeatherRequest(String city, String countryAlphaCode, String temp) {
        CITY = city;
        COUNTRY_ALPHA_CODE = countryAlphaCode;
        TEMP = temp;
    }

    public String getCity() {
        return CITY;
    }

    public String getCountryAlphaCode() {
        return COUNTRY_ALPHA_CODE;
    }

    public String getTemp() { return TEMP; }
}
