package getUser;


import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class tests  {

    private static  JSONObject temperatureContainer;
    private static  JSONObject weatherContainer;
    private static  JSONObject weatherContainerType;
    private static int tally;
    private static int dayTally;
    public static void main(String[] args) throws Exception {


        /*********
         Currently reading the data from file
         ********/

        Object obj = new JSONParser().parse(new FileReader("JSONARRAY.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;


        int totalDays =  Integer.parseInt( jo.get("cnt").toString());
        System.out.println("Weather Forcast for " + totalDays + " Days");

        //  boolean cityName =  jo.get("city").toString().contains("Sydney");

        JSONObject ja = (JSONObject) jo.get("city");
        System.out.println("City "+ja.get("name") +" : "+ja.get("name").equals("Sydney"));

/*****


*/

        JSONArray forList = (JSONArray) jo.get("list");
        double pi = 0;
        for (int i = 0; i < forList.size(); i++) {

             temperatureContainer = (JSONObject) forList.get(i);
      /*

       Temperature over 20 'C Celsius
       */

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

        System.out.println("In Next 2 Weeks, total Days with temperature Over 20 'Celsius  : " + tally );



      /****
      NOW Check how many days are Sunny -
       reference:   https://openweathermap.org/weather-conditions

       Since Weather Data is Array, thus extracting data separately

       */


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


             System.out.println("In Next 2 Weeks, total Sunny Days : " + dayTally );






    } // main method

} // class
