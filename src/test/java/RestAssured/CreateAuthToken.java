package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAuthToken {
    public static void main(String[] args) {
        getAuthToken();
    }

    public static void getAuthToken(){
        //set up request specification
        //curl --location 'https://restful-booker.herokuapp.com/auth' \
        //--header 'Content-Type: application/json' \
        //--data '{
        //    "username" : "admin",
        //    "password" : "password123"
        //}'

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/auth";
        //set up content type
        RequestSpecification reqSpecs = RestAssured.given().contentType("application/json"); //.log().all().relaxedHTTPSValidation();
        //setup query param or path param
//        reqSpecs.queryParam("")
//        reqSpecs.queryParams()  //-- setting up list of query params
//        reqSpecs.pathParam("");
//        reqSpecs.queryParams()   //-- setting up list of query params
        //Set up headers
//        reqSpecs.header("Content-Type", "application/json")
//        reqSpecs.headers()

        //set up request body
        String body  = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        reqSpecs.body(body);

        //Make a request call and save response
        Response response = reqSpecs.post(); //.then().log().all().extract().response();

        //use response obj to validate the response body or to extract any values
        //to get the token
        response.getStatusLine(); //to get status line and status code
        response.getStatusCode();

        //to get response headers
        response.getHeaders();
//        response.getHeader("give header name")
        System.out.println("response time: "+response.getTime());

        //response body
        System.out.println("Response body \n"+response.getBody().asPrettyString());

        // to extract response body content using json path

        String token = response.jsonPath().get("token");
        System.out.println("Token value: "+ token);

    }
}
