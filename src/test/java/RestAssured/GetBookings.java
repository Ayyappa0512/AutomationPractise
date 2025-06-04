package RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBookings {
    public static void main(String[] args) {
        getBookingIds();
    }

    public static Response getBookingIds(){
        //curl --location 'https://restful-booker.herokuapp.com/booking'

        baseURI = "https://restful-booker.herokuapp.com";
        basePath = "";

        Response res = given()
                        //.log().all()
                        .when().get("/booking")
                        .then()
                        //.log().all()
                        .statusCode(equalTo(200))
                        .extract().response();

        return res;
//        System.out.println("Status code"+res.getStatusCode());
//        JsonPath js = new JsonPath(res.asPrettyString());
//        List<Object> list =  js.getList("$");
//        List<Integer> list1 = js.getList("bookingid");
//        list1.stream().filter(x -> x < 10).collect(Collectors.toList()).forEach(x -> System.out.println(x.toString()));
//        list.forEach(x -> System.out.println(x.toString()));

    }
}
