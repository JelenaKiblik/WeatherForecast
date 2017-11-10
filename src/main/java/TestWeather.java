package java;

import org.junit.Assert;
import org.junit.Test;
import validator.Validator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestWeather {

    private Validator validator = new Validator("Tallinn", "EE", "celsius");
    private WeatherRequest request = new WeatherRequest("Tallinn", "EE", "celsius");
    private WeatherCollection collection = new WeatherCollection();
    private WeatherReport report = collection.getCurrentWeather(request);

    @Test
    public void testSuccessfulConnectionToAPI() {
        String strUrl = "http://samples.openweathermap.org";
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            assertEquals(HttpURLConnection.HTTP_OK, urlConnection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNameOfCity() {
        try {
            assert report.getCityName().equals(request.getCity());
        } catch (NullPointerException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCountry() {
        try {
            assert report.getCountry().equals(request.getCountryAlphaCode());
        } catch (NullPointerException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCoordinatesFormatTwoDigits() {
        validator.validateCoordinateFormat("33:92");
    }

    @Test
    public void testCoordinatesFormatOneDigit() {
        validator.validateCoordinateFormat("2:2");
    }

    @Test
    public void testCoordinatesFormatCommaSeparator() {
        validator.validateCoordinateFormat("22,33");
    }

    @Test
    public void testCoordinatesFormatSpaceSeparator() {
        validator.validateCoordinateFormat("33 44");
    }

    @Test
    public void testCanGetCityNameFromResponse() {
        assert report.getCityName().equals(request.getCity());
    }

    @Test
    public void testValidateTempLowestHighestEqual() {
        validator.validateLowestTempIsSmallerThanHighestTemp(55, 55);
    }

    @Test
    public void testValidateTempHighestSmallerThanLowest() {
        validator.validateLowestTempIsSmallerThanHighestTemp(3, 55);
    }

    @Test
    public void testValidateTempHighestBiggerThanLowest() {
        validator.validateLowestTempIsSmallerThanHighestTemp(33, 5);
    }

    @Test
    public void testValidateTempCelsiusTooHigh() {
        validator.validateTemperatureIsInCorrectRange("celsius", 100, 2);
    }

    @Test
    public void testValidateTempCelsiusTooLow() {
        validator.validateTemperatureIsInCorrectRange("celsius", 30, -100);
    }

    @Test
    public void testValidateTempCelsiusCorrect() {
        validator.validateTemperatureIsInCorrectRange("celsius", 30, 30);
    }

    @Test
    public void testValidateTempCelsiusLowestTempHigherThanHighest() {
        validator.validateTemperatureIsInCorrectRange("celsius", 2, 30);
    }

    @Test
    public void testCanGetHighestTempFromResponse() {
        try {
            assert report.getHighestTemperature() != 0;
        } catch (AssertionError e) {
            fail("Cannot find highest temperature.");
        }
    }

    @Test
    public void testCanGetLowestTempFromReport() {
        try {
            assert report.getLowestTemperature() != 0;
        } catch (AssertionError e) {
            fail("Cannot find lowest temperature.");
        }
    }


    @Test
    public void testValidateLatitudeTooBig() {
        validator.validateCoordinateRange(100, 20);
    }

    @Test
    public void testValidateLatitudeTooSmall() {
        validator.validateCoordinateRange(-100, 20);
    }

    @Test
    public void testValidateLongitudeTooBig() {
        validator.validateCoordinateRange(60, 200);
    }

    @Test
    public void testValidateLongitudeTooSmall() {
        validator.validateCoordinateRange(60, -200);
    }

    @Test
    public void testValidateLatitudeAndLongitudeCorrect() {
        validator.validateCoordinateRange(90, 180);
    }


    @Test
    public void testCanGetHighestTempFromResponse() {
        try {
            assert report.getHighestTemperature() != 0;
        } catch (AssertionError e) {
            fail("Cannot find highest temperature.");
        }
    }

    @Test
    public void testCanGetLowestTempFromReport() {
        try {
            assert report.getLowestTemperature() != 0;
        } catch (AssertionError e) {
            fail("Cannot find lowest temperature.");
        }
    }

}