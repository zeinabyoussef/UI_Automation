import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import javax.swing.plaf.FileChooserUI;
import java.io.File;

public class Screenshots {

    WebDriver driver;

     @Test
    public void testscreenshot()
     {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://the-internet.herokuapp.com/");
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest=new File("src/test/resources/google.png");
            try{
                FileUtils.copyFile(src,dest);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
     }
}
