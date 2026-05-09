import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

    WebDriver driver;


    @Test
    public void testdropdown() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        By dropdown = By.id("dropdown");
        Select select=new Select(driver.findElement(dropdown));
        select.selectByVisibleText("Option 1");
    }


}
