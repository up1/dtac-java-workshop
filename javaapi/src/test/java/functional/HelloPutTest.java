package functional;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HelloPutTest {

    @Test
    public void
    hello_with_response_code() {
        Map<String, Object> input = new HashMap<>();
        input.put("id", 1);
        input.put("status", 1);

        given()
              .contentType("application/json")
              .body(input)
        .when().put("/demo/parking_lot/booking/1")
        .then().statusCode(200);
    }


    @Test
    public void
    hello_with_response_data() {
        Map<String, Object> input = new HashMap<>();
        input.put("id", 1);
        input.put("status", 1);

        given()
                .contentType("application/json")
                .body(input)
        .when().put("/demo/parking_lot/booking/1")
        .then()
                .body("code", equalTo(200))
                .body("description", equalTo("Success"));
    }



}



