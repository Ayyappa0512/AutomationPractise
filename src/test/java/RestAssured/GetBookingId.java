package RestAssured;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetBookingId {

    public static void main(String[] args) {
        getBookingId("1710");
    }

    public static Response getBookingId(String bookingId){
//        curl --location 'https://restful-booker.herokuapp.com/booking/55'

        Response res = given()
                //.log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}") //--id is the path parameter
                .pathParam("id", bookingId)
                .when().get()
                .then()
                //.log().all()
                .extract().response();
//        System.out.println(res.asPrettyString());

//        Map<String, Object> mappedData = res.jsonPath().getMap("$"); // -- $ represent the root json

//        System.out.println("mapped data \n"+mappedData);
        return res;
    }
}
