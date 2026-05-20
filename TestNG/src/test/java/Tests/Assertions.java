package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

  WebDriver driver;

    @Test
    public void fakeTest() {
        boolean flag = false;
        Assert.assertFalse(flag, "Flag should be false");
        String name = "John";
        Assert.assertNotEquals(name, "nada", "Name should be John");
    }
    @BeforeMethod
    public void setup() {
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test
    public void invalidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        /*
        1. Enter username
        2. Enter password
        3. Click on login button
        4. Verify error message is displayed
         */
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_pass");
        driver.findElement(By.id("login-button")).click();
        String errorMessageDisplayed = driver.findElement(By.tagName("h3")).getText();
        softAssert.assertEquals(errorMessageDisplayed, "Epic sadface: Username and password ");
        softAssert.assertTrue(driver.getCurrentUrl().contains("index.html"), "URL should contain index.html");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
