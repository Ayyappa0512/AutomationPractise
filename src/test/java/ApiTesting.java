import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTesting {

    public static void main(String[] args) {
//        getWithoutBBDStyle();
        getWithBDDStyle();

    }

    public static void getWithBDDStyle(){
        baseURI ="https://reqres.in/api";
        basePath = "/users";
        Response res = given().queryParam("per_page","4")
                .queryParam("page", "2")
                .header("x-api-key","reqres-free-v1")
                .relaxedHTTPSValidation()
                .when().get()
                .then()
//                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("total_pages", equalTo(3))
                .extract().response();

        JsonPath js =new  JsonPath(res.asPrettyString());
        Map<Object, Object> user = js.getMap("data[0]");

        int i =1;
        for (Object prop: user.keySet()){
            System.out.println(i+" "+prop+" : "+user.get(prop));
            i++;
        }

    }

    public static void getWithoutBBDStyle(){

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.basePath = "/users";
        RequestSpecification requestSpecification = RestAssured.given().queryParam("per_page","4").queryParam("page", "2");
        Response response = requestSpecification.get();
        List<String> emails = response.jsonPath().getList("data.email");
        System.out.println(emails);
    }
}
