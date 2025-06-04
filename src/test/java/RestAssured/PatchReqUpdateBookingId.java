package RestAssured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PatchReqUpdateBookingId {
    public static void main(String[] args) {
        System.out.println(partialUpdateBookingId(AuthToken.getAuthToken(),"10").getStatusCode());
    }

    public static Response partialUpdateBookingId(String authToken, String Id){
//        curl --location --request PATCH 'https://restful-booker.herokuapp.com/booking/8' \
//        --header 'Content-Type: application/json' \
//        --header 'Accept: application/json' \
//        --header 'Cookie: token=b73b366926b8c12' \
//        --data '{
//        "firstname" : "Ma ry",
//                "lastname" : "Brown"
//    }'
        String data = "{\n" +
                "    \"firstname\" : \"Mary\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        Response res = given()
//                .log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie",  "token="+authToken)
                .when().patch("https://restful-booker.herokuapp.com/booking/"+Id)
                .then()
//                .log().all()
                .extract().response();
        return res;
    }
}
