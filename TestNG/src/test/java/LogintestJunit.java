import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.extension.ExtendWith;
public class LogintestJunit {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @RepeatedTest(10)
    public void ValidloginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        Assertions.assertTrue(
                driver.findElement(By.id("flash")).isDisplayed(),
                "Flash message should be displayed"
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}