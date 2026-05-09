import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Windows {

    WebDriver driver;

    @Test
    public void testwindows()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        By clickhere = By.cssSelector(".example>a");
        By newTab =By.cssSelector("body > .example>h3");
        String parent= driver.getWindowHandle();
        driver.findElement(clickhere).click();
        //very very very important please راجعي عليها كويس
        String child= driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(newTab).getText());


    }



}