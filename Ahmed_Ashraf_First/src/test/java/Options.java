import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Options {

    WebDriver driver;

     @Test
    public void testoptions() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.setBrowserVersion("latest");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setAcceptInsecureCerts(true);
         driver = new EdgeDriver(options);
         driver.navigate().to("https://the-internet.herokuapp.com/windows");
     }
}
