import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Categories {
    String Base_URL = "https://api.escuelajs.co/api/v1/";
    String endPoint = "categories";


    public Response getAllCategory()
    {
        return RestAssured.given().log().all().get(Base_URL+endPoint).then().extract().response();
    }

  @Test
    public void getCategories() {

      SoftAssert softAssert = new SoftAssert();
      Response response=getAllCategory();
      response.prettyPrint();
      JsonPath jsonPath = response.jsonPath();
      Assert.assertEquals(response.statusCode(), 200);
      softAssert.assertEquals(
              jsonPath.getString("[0].name"),
              "Clothes",
              "name is not correct"
      );

      softAssert.assertTrue(
              jsonPath.getString("[0].slug").contains("clothes"),
              "slug is not correct"
      );

      softAssert.assertTrue(
              jsonPath.getString("[0].image").startsWith("http"),
              "image is not valid");
      softAssert.assertAll();

    }




}
