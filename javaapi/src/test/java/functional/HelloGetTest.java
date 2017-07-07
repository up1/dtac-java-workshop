package functional;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;

public class HelloGetTest {

    @Test
    public void
    hello_with_response_code() {
        given()
                .when().get("/demo/parking_lot/available")
                .then().statusCode(200);

    }

    @Test
    public void
    hello_with_size_of_data() {
        given()
                .when().get("/demo/parking_lot/available")
                .then().body("size()", equalTo(5));

    }

    @Test
    public void
    hello_with_check_data_in_each_element() {
        given()
        .when().get("/demo/parking_lot/available")
        .then()
                .body("[0].level", equalTo(1))
                .body("[0].amount", equalTo(10));

    }

}



