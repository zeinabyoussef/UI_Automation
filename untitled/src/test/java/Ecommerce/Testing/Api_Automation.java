package Ecommerce.Testing;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.Map;

public class Api_Automation
{


@Test
 public void api_automationGETtest()
{

    RestAssured.given()
            .baseUri("https://api.escuelajs.co/api")
            .headers("Content-Type","application/json")
            .when()
            .get("v1/products")
            .then()
            .statusCode(200)
            .log().all();


 }
 @Test
 public void api_automationPOSTtest()
    {

        RestAssured.given()
                .baseUri("https://api.escuelajs.co/api")
                .headers("Content-Type","application/json")
                .body("\"title\": \"New Product\",\n" +
                        "  \"price\": 10,\n" +
                        "  \"description\": \"A description\",\n" +
                        "  \"categoryId\": 1,\n" +
                        "  \"images\": [\"https://placehold.co/600x400\"]")
                .when()
                .post("v1/products/1")
                .then()
                .log().all();


    }
}
