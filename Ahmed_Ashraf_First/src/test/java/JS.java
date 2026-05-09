import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JS {

WebDriver driver;
    @Test
    public void testjs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/scrolling.html");
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("scroll_text")));
    }
}
