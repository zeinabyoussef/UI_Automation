import CustomListeners.TestngListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestngListeners.class)
public class Logintest {

    WebDriver driver;

    @Ignore
    @Test
    public void faketest() {
        String token=null;
        Assert.assertNull(token, "Token should be null");
    }
    @BeforeGroups
    public void setup() {
        LogUtils.info("Setting up the WebDriver and navigating to the login page");
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       driver.get("https://the-internet.herokuapp.com/login");
       LogUtils.debug("Setup completed");

    }
    @Test(groups = {"valid","smoke"})
    public void ValidloginTest() {
        LogUtils.info("Starting ValidloginTest");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
       // driver.findElement(By.cssSelector(".example > a")).click();
        LogUtils.info("ValidloginTest completed");
    }
    @Test(groups ={"invalid","smoke"})
    public void InValidusernameloginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
        //driver.findElement(By.cssSelector(".example > a")).click();


    }
    @Test(groups ={"invalid","smoke"})
    public void InValidpasswordloginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("@3!");
        driver.findElement(By.className("radius")).click();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
       // driver.findElement(By.cssSelector(".example > a")).click();


    }

    @Test(dependsOnMethods = "ValidloginTest")
    public void logoutTest() {
        driver.findElement(By.cssSelector(".example > a")).click();
        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged out of the secure area!"), "Logout message should be displayed");

    }
    @AfterGroups("loginfync")
    public void tearDown() {
        driver.quit();
    }
}
