package RestAssured;

import dev.failsafe.internal.util.Assert;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateBooking {
    public static void main(String[] args) {
        createBooking();
        //1395
    }

    public static Response createBooking(){
//        curl --location 'https://restful-booker.herokuapp.com/booking' \
//        --header 'Content-Type: application/json' \
//        --data '{
//        "firstname" : "Ravi",
//                "lastname" : "Sampala",
//                "totalprice" : 111,
//                "depositpaid" : true,
//                "bookingdates" : {
//            "checkin" : "2026-01-01",
//                    "checkout" : "206-02-01"
//        },
//        "additionalneeds" : "Breakfast"
//    }'
        String data = "{\n" +
                "    \"firstname\" : \"Ravi\",\n" +
                "    \"lastname\" : \"Sampala\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2026-01-01\",\n" +
                "        \"checkout\" : \"206-02-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        Response res = given()
                //.log().all()
                .header("Content-Type", "application/json")
                .body(data)
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                //.log().all()
                .extract().response();
        return  res;

    }
}
