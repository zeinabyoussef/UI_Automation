import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;
    By jsAlert= By.cssSelector("[onclick=\"jsAlert()\"]");
    By jsprompt= By.cssSelector("[onclick=\"jsPrompt()\"]");
    By jsconfirm= By.cssSelector("[onclick=\"jsConfirm()\"]");


    @Test
    public void testalertconfirm()
     {
         driver = new EdgeDriver();
         driver.manage().window().maximize();
         driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
         driver.findElement(jsAlert).click();
         driver.switchTo().alert().accept();

     }
     @Test
    public void testalertprompt()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsprompt).click();
        driver.switchTo().alert().sendKeys("Ahmed Ashraf");
        driver.switchTo().alert().accept();
    }
    @Test
    public void testalertdismiss()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsconfirm).click();
        driver.switchTo().alert().dismiss();

    }
    @Test
    public void testalertgettext()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click();
         String alerttext= driver.switchTo().alert().getText();
         System.out.println(alerttext);
    }


}
