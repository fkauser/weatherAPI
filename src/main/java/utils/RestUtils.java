package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import static org.junit.Assert.assertEquals;


public class RestUtils {


    /*
    *Sets Base URI*
    Before starting the test, we should set the Base URI e.g "http://localhost:3000"
    Server URL must be provided in the Property File
    */
    public static ResponseOptions<Response> setBaseURI(String baseURI) {
        try {
            RestAssured.baseURI = baseURI;

        } catch (Exception e) {
            System.out.println("Exception : setBaseURI : FAILED TO LOAD URI LINK");
        }
        return null;
    }


    /*
       *Reset Base URI (after test)*
       After the test, we should reset the RestAssured.baseURI
       */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /*
    *Reset base path (after test)*
    After the test, we should reset the RestAssured.basePath
    */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }


    /*
     *Sets ContentType*
     We should set content type such as JSON
     */
    public static void setContentType(ContentType Type) {
        RestAssured.given().contentType(Type);
    }

    /*
        *Sets New User/Update User*
        This method takes the fixed values, can be modified to dynamic
    */
    public JSONObject addNewUser( String fname, String lname, String email) {
        JSONObject newUser = new JSONObject();
        try {

            newUser.put("first_name", fname);
            newUser.put("last_name", lname);
            newUser.put("email", email);

        } catch (Exception e) {
            System.out.println("Exception : **addNewUser**");
            System.out.println("Exception : Only 3 Entries allowed");
        }

        return  newUser;
    }

    /*
     INACTIVE
     *Sets a API type GET, POST, PUT, DELETE etc*

     */

    public static void requestToServer(Method TYPE, String str) {

            RestAssured.given().request(TYPE, str);

    }


    /*
        response status returned - verification

        */
    public void checkStatusIs200 (Response response) {

      assertEquals("Status Check!", 200, response.getStatusCode());
       }

    public void checkStatusIs201 (Response response) {

        assertEquals("Status Check!", 201, response.getStatusCode());
    }





} // end class
