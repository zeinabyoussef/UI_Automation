import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LogintestParallel {

   ThreadLocal<WebDriver> driverthreadlocal= new ThreadLocal<>();
    WebDriver driver;
    @Ignore
    @Test
    public void faketest() {
        String token=null;
        Assert.assertNull(token, "Token should be null");
    }
    @BeforeGroups
    public void setup() {
       driver = ThreadGuard.protect(new EdgeDriver());
       driverthreadlocal.set(driver);
        driverthreadlocal.get().manage().window().maximize();
        driverthreadlocal.get().get("https://the-internet.herokuapp.com/login");

    }
    @Test(groups = {"valid","smoke"})
    public void ValidloginTest() {
        driverthreadlocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverthreadlocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverthreadlocal.get().findElement(By.className("radius")).click();
        Assert.assertTrue(driverthreadlocal.get().findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
        driverthreadlocal.get().findElement(By.cssSelector(".example > a")).click();


    }

    @Test(groups ={"invalid","smoke"})
    public void InValidusernameloginTest() {
        driverthreadlocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverthreadlocal.get().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driverthreadlocal.get().findElement(By.className("radius")).click();
        Assert.assertTrue(driverthreadlocal.get().findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
        driverthreadlocal.get().findElement(By.cssSelector(".example > a")).click();


    }
    @Test(groups ={"invalid","smoke"})
    public void InValidpasswordloginTest() {
        driverthreadlocal.get().findElement(By.id("username")).sendKeys("tomsmith");
        driverthreadlocal.get().findElement(By.id("password")).sendKeys("@3!");
        driverthreadlocal.get().findElement(By.className("radius")).click();
        Assert.assertTrue(driverthreadlocal.get().findElement(By.id("flash")).isDisplayed(), "Flash message should be displayed");
        //throw new RuntimeException("Intentional failure to test priority");
        driverthreadlocal.get().findElement(By.cssSelector(".example > a")).click();


    }

    @Test(dependsOnMethods = "ValidloginTest")
    public void logoutTest() {
        driverthreadlocal.get().findElement(By.cssSelector(".example > a")).click();
        String msg = driverthreadlocal.get().findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged out of the secure area!"), "Logout message should be displayed");

    }
    @AfterGroups("loginfync")
    public void tearDown() {
        driverthreadlocal.get().quit();
    }
}
