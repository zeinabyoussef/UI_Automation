import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class DynamicLocator {

    WebDriver driver;

     @Test
    public void testdynamiclocator() {
         driver = new EdgeDriver();
         driver.manage().window().maximize();
         driver.navigate().to("https://jqueryui.com/");
         chooseCategory("Contribute");
         chooseSubCategory("Code");
     }
     ///////Don't Forget Waits /////////////// very important /////////////

     public void chooseSubCategory(String option)
     {
         driver.findElement(By.xpath("//a[.='" + option + "']")).click();
     }

     public void chooseCategory(String option)
    {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//li[@class='dropdown'] //a[.='"+ option +"']"))).perform();
    }


}
