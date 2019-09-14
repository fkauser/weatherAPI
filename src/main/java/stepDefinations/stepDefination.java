package stepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import utils.Coms;
import utils.RestUtils;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class stepDefination {

    RestUtils restUtil = new RestUtils();
    Coms com = new Coms();

    public static JSONObject jo;
    private static  JSONObject temperatureContainer;
    private static  JSONObject weatherContainer;
    private static  JSONObject weatherContainerType;
    private static int tally;
    private static int dayTally;

        @Given("^Activate a URL$")
        public void activateAURL() {
            com.setup();
            restUtil.setBaseURI(com.URI);
            com.getrequest = RestAssured.given(); // Request Instance
        }


    @When("^Pass the City Name, Access and Days for weather forecast$")
    public void passTheCityNameAccessAndDaysForWeatherForecast()  throws ParseException {


        String URL = com.Path+"q="+com.City+","+com.CountryCode+"&units="+com.Units+"&APPID="+com.ID+"&cnt="+com.Days;
        com.getResponse = com.getrequest.request(Method.GET, URL);
        String obj = com.getResponse.getBody().print();


        //Converting String to JSON Object, to extract data with JSON libraries
        JSONParser parser = new JSONParser();
        jo = (JSONObject) parser.parse(obj);
    }


    @Then("^Validate the Number of days$")
    public void validateTheNumberOfDays() throws Throwable {
        int totalDays =  Integer.parseInt( jo.get("cnt").toString());
        System.out.println("WEATHER FORECAST FOR " + totalDays + " DAYS.");

        restUtil.checkStatusIs200(com.getResponse);
        assertEquals("Validate Number of Days!", 14, totalDays);
        System.out.println("***Days Validation Completed***");
    }

    @Then("^Validate the City Name$")
    public void validateTheCityName()  {
        JSONObject ja = (JSONObject) jo.get("city");
        System.out.println("City "+ja.get("name") +" : "+ja.get("name").equals(com.City));
        System.out.println("***CITY Validation Completed***");
       // assertTrue(check);

        }


    @Then("^Total Number of Days in the next two weeks$")
    public void totalNumberOfDaysInTheNextTwoWeeks() {

        JSONArray forList = (JSONArray) jo.get("list");
        double pi = 0;
        for (int i = 0; i < forList.size(); i++) {
            temperatureContainer = (JSONObject) forList.get(i);
            Map temperature = ((Map) temperatureContainer.get("main"));

            // iterating temperature Map
            Iterator<Map.Entry> itr1 = temperature.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                Boolean check = pair.getKey().toString().equals("temp_max");

                try {
                    if (check == true) {
                        pi = Double.parseDouble(pair.getValue().toString());

                        if (pi > 20) {
                            ++tally;
                        } //if
                    } // if
                }catch(Exception e) {
                    System.out.println("Error in Counting Days");
                }

            } //while
        } // for

        System.out.println("IN NEXT 2 WEEKS, TOTAL DAYS WITH TEMPERATURE OVER 20 'CELSIUS  : " + tally );
    }


    @Then("^In Next Two Weeks total Sunny Days$")
    public void inNextTwoWeeksTotalSunnyDays()  {
        JSONArray extractListWeather = (JSONArray) jo.get("list");


        for (int i = 0; i < extractListWeather.size(); i++) {

            weatherContainer = (JSONObject) extractListWeather.get(i);

            JSONArray weatherArray = (JSONArray) weatherContainer.get("weather");
            for (int a = 0; a < weatherArray.size(); a++) {
                weatherContainerType = (JSONObject) weatherArray.get(a);
                String day =  weatherContainerType.get("description").toString();

                switch (day) {
                    case "clear sky":
                        ++dayTally;
                        break;
                } // switch

            } // for - weatherArray

        } //  for - extractListWeather


        System.out.println("IN NEXT 2 WEEKS, TOTAL SUNNY DAYS : " + dayTally );

    }


} // stepDefination

