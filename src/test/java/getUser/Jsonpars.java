package getUser;

import io.restassured.mapper.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.JSONObject.*;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;


public class Jsonpars{

    private static int tally;

    public static void main(String[] args) throws Exception
    {

      //  Object obj = new JSONParser().parse(new FileReader("JSONARRAY.json"));
        Object obj = new JSONParser().parse(new FileReader("JSONARRAY.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

       // System.out.println(jo.size());

        int totalDays =  Integer.parseInt( jo.get("cnt").toString());
        System.out.println(totalDays);



      //  boolean cityName =  jo.get("city").toString().contains("Sydney");

        JSONObject ja = (JSONObject) jo.get("city");
        System.out.println("City "+ja.get("name") +":"+ja.get("name").equals("Sydney"));


        /****************
         *
         * Temperature over 20 Degree
         *
         */
/*
        JSONArray temp =  (JSONArray) jo.get("list");
        JSONObject temp2 = (JSONObject) temp.get(0);
        System.out.println( "........" + temp2);
        JSONObject temp3 = (JSONObject) temp2.get("main");


        System.out.println("Max Temp "+temp3.get("temp_max"));
*/

        JSONArray employeeList = (JSONArray) jo.get("list");

               System.out.println("Max Temp "+employeeList);
        employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
System.out.println(".........." + tally);

       } // main

    private static void parseEmployeeObject(JSONObject employee)
    {


        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("main");
        String str = employeeObject.get("temp_max").toString();


        double pi = Double.parseDouble(str);
        if(pi>10){

            tally++;
            //System.out.println("..." + tally);
        }

    }

} // class
