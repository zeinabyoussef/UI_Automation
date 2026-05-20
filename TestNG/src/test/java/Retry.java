import CustomListeners.TestngListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Retry {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       driver.get("https://the-internet.herokuapp.com/login");

    }
    @Test(groups = {"valid","smoke"},retryAnalyzer=TestngListeners.class)
    public void ValidloginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
       // driver.findElement(By.cssSelector(".example > a")).click();
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
