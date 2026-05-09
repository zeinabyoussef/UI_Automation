import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckandRadio {


    WebDriver driver;

    @Test
    public void testcheckbox() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/checkbox_Radio.html");
        By checkbox1 =  By.id("noClub");
        driver.findElement(checkbox1).click();
        By checkbox2 =  By.id("Ahly");
        System.out.println( driver.findElement(checkbox2).isSelected());

    }

    @Test
    public void testradiobutton() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/checkbox_Radio.html");
        By highradio= By.id("radio-button-1");
        System.out.println( driver.findElement(highradio).isSelected());
        driver.findElement(highradio).click();
        System.out.println( driver.findElement(highradio).isSelected());

    }

}
