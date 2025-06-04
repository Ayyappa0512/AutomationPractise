package RestAssured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DelBookingId {
    public static void main(String[] args) {
        System.out.println(deleteBookingId(AuthToken.getAuthToken(), "10").getStatusLine());

    }

    public static Response deleteBookingId(String authToken, String Id){
//        curl --location --request DELETE 'https://restful-booker.herokuapp.com/booking/1773' \
//        --header 'Content-Type: application/json' \
//        --header 'Cookie: token=b73b366926b8c12'

        Response res = given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+authToken)
                .when().delete("https://restful-booker.herokuapp.com/booking/"+Id)
                .then()
//                .log().all()
                .extract().response();
        return res;
    }
}
