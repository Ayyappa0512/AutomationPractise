package RestAssured;

import io.restassured.response.Response;

import static RestAssured.AuthToken.getAuthToken;
import static io.restassured.RestAssured.given;

public class PutReqUpdateBookingId {
    public static void main(String[] args) {
        System.out.println(updateBookingId(getAuthToken(), "10").getStatusLine());
    }

    public static Response updateBookingId(String authToken, String Id){
//        curl --location --request PUT 'https://restful-booker.herokuapp.com/booking/8' \
//        --header 'Content-Type: application/json' \
//        --header 'Accept: application/json' \
//        --header 'Cookie: token=b73b366926b8c12' \
//        --data '{
//        "firstname": "Mary",
//                "lastname": "Jones",
//                "totalprice": 507,
//                "depositpaid": false,
//                "bookingdates": {
//            "checkin": "2025-01-17",
//                    "checkout": "2025-04-01"
//        },
//        "additionalneeds": "Dinner"
//    }'

        String data = "{\n" +
                "    \"firstname\": \"Bala\",\n" +
                "    \"lastname\": \"Prathap\",\n" +
                "    \"totalprice\": 510,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2025-01-17\",\n" +
                "        \"checkout\": \"2025-04-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        Response res = given()
//                .log().all()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","token="+authToken)
                .body(data)
                .when().put("https://restful-booker.herokuapp.com/booking/"+Id)
                .then()
//                .log().all()
                .extract().response();
        return res;
    }
}
