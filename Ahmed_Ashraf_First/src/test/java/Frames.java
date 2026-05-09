import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Frames
{
    WebDriver driver;

     @Test
    public void testframes()
     {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
            By frame1= By.xpath("//body[contains(text(),'LEFT')]");
            By frame2= By.xpath("//body[contains(text(),'BOTTOM')]");
            // parent > top > left > top > bottom
            //very very important please راجعي عليها كويس
            driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
            driver.switchTo().frame("frame-top").switchTo().frame("frame-bottom");
            System.out.println(driver.findElement(frame1).getText());
            System.out.println(driver.findElement(frame2).getText());
     }
}
