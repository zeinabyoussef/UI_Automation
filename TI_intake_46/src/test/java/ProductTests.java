import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class ProductTests {

  String Base_URL = "https://api.escuelajs.co/api/v1/";
  String endPoint = "products";


  public Response getSingleProduct(int id)
  {
    return RestAssured.given().log().all().get(Base_URL+endPoint+"/"+id).then().extract().response();
  }

 // public getProductList()
 // {

 // }

 @Test
   public void getProducts() {
     SoftAssert softAssert = new SoftAssert();
     Response response=getSingleProduct(1);
     response.prettyPrint();
     JsonPath jsonPath = response.jsonPath();
     Assert.assertEquals(response.statusCode(), 200);
     softAssert.assertTrue(jsonPath.getInt("price")>0,"Price is not correct");
     softAssert.assertTrue(jsonPath.getString("description").contains("shoes"),"Description is not correct");
     softAssert.assertAll();

   }
  @Test
  public void getSingleProduct() {
    SoftAssert softAssert = new SoftAssert();
    Response response=getSingleProduct(221);
    response.prettyPrint();
    JsonPath jsonPath = response.jsonPath();
    Assert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(jsonPath.getInt("price"),94,"Price is not correct");
    softAssert.assertTrue(jsonPath.getString("description").contains("PR"),"Description is not correct");
    softAssert.assertAll();
  }
  @Test
  public void getSingleInvalidProducts() {
    SoftAssert softAssert = new SoftAssert();
    Response response=getSingleProduct(0);
    response.prettyPrint();
    JsonPath jsonPath = response.jsonPath();
    Assert.assertEquals(response.statusCode(), 400);
    softAssert.assertEquals(jsonPath.getString("name"),"Entity not found");
  }


}
