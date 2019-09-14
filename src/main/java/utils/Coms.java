package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Coms {

    public static RequestSpecification getrequest = null;
    public static Response getResponse= null;
    public static String URI, Path, City, CountryCode, Units, ID, Days ;


/*
        ***Sets properety values***
        This method must initialize first
    */

    public static void setup() {
        PropertyReader getpropertyValues = new PropertyReader();
        URI = getpropertyValues.getPropValues("URI");
        Path = getpropertyValues.getPropValues("Path");
        City = getpropertyValues.getPropValues("City");
        CountryCode = getpropertyValues.getPropValues("CountryCode");
        ID = getpropertyValues.getPropValues("ID");
        Units = getpropertyValues.getPropValues("Units");
        Days = getpropertyValues.getPropValues("Days");

    }
}
