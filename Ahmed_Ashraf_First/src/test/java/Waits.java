import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    WebDriver driver;
    By startButton = By.tagName("button");
    By msg = By.cssSelector("#finish>h4");
    WebDriverWait wait;


    @Test
    public void implicitwait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startButton).click();
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void explicitwait() {
        ///////very important to use page load strategy//////////
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);//dont wait for page to load
        driver = new EdgeDriver(options);
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(startButton));
        driver.findElement(startButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
        //lamda expression second choice
        //new WebDriverWait(driver,Duration.ofSeconds(5)).until(d->driver.findElement(msg).isDisplayed());

        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void fluentwait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startButton).click();
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).
               pollingEvery(Duration.ofMillis(300)).withMessage("element not found"+msg.toString()).
               until(ExpectedConditions.visibilityOfElementLocated(msg));
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }
}
