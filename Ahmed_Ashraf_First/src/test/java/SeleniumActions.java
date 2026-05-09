import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumActions
{

    WebDriver driver;

    @Test
    public void testdoubleclick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/mouse.html");
        By doubleclic  = By.id("dblClickBtn");
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleclic)).perform();



    }

    @Test
    public void testRightclick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/mouse.html");
        By RightClick  = By.id("riClickBtn");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(RightClick)).perform();



    }
    @Test
    public void testHovring() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/mouse.html");
        By hover  = By.cssSelector("[class=\"btn btn-primary logout\"]");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(hover)).perform();



    }
    @Test
    public void testdragdrop() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/dragDrop.html");
        By dragdropsrc  = By.cssSelector("[alt=\"my Image\"]");
        By dragdropdest  = By.cssSelector("[id=\"dropZone\"]");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragdropsrc),driver.findElement(dragdropdest)).perform();



    }
    @Test
    public void testclickhold() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/dragDrop.html");
        By dragdropsrc  = By.cssSelector("[alt=\"my Image\"]");
        By dragdropdest  = By.cssSelector("[id=\"dropZone\"]");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(dragdropsrc)).moveToElement(driver.findElement(dragdropdest)).release().perform();



    }

    @Test
    public void testKeys() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).perform();
        reset();
           driver.findElement(By.id("target")).sendKeys("nada");
    }
    @Test
    public void scrolling() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aa-practice-test-automation.vercel.app/Pages/scrolling.html");
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.cssSelector("[id=\"scroll_text\"]"))).perform();
    }

    public void reset()
    {
        ((RemoteWebDriver)driver).resetInputState();
    }


}
