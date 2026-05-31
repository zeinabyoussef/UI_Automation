import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Priority {

    WebDriver driver;

    @Ignore
    @Test
    public void faketest() {
        String token=null;
        Assert.assertNull(token, "Token should be null");
    }
    @BeforeClass
    public void setup() {
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       driver.get("https://the-internet.herokuapp.com/login");

    }
    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");

    }

    @Test(dependsOnMethods = "loginTest")
    public void logoutTest() {
        driver.findElement(By.cssSelector(".example > a")).click();
        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged out of the secure area!"), "Logout message should be displayed");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
