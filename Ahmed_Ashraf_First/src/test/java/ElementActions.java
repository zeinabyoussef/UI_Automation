import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActions {
    WebDriver driver;
    By username = new ByChained(By.id("loginForm"), By.id("inputUsername"));
    By Password = new By.ByCssSelector("#inputPassword");
    By Loginbutton = RelativeLocator.with(By.tagName("button")).below(Password);
    By checkbox = new By.ByCssSelector("[type=\"checkbox\"]");
    //By Uploadfile = By.id("regularFileInput");
    By Uploadfile = By.id("fileInput");


    @Test
    public void Logintc() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        //findElement(username).sendKeys("admin");
        type(username, "admin");
        // findElement(username).clear();
        //findElement(Password).sendKeys("admin");
        type(Password, "admin");
        System.out.println(findElement(username).isDisplayed());
        System.out.println(findElement(username).isEnabled());
        // findElement(checkbox).click();
        // findElement(Loginbutton).click();
        clicking(checkbox);
        clicking(Loginbutton);


    }

    @Test
    public void uploadfiletc() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/uploadFile.html");

        // findElement(Uploadfile).sendKeys("E:\\ITI Materials\\Automation_Ahmed_Ashraf\\Ahmed_Ashraf_First\\src\\test\\resources\\test.txt");
        UploadFile(Uploadfile, "src\\\\test\\\\resources\\\\test.txt");

    }

    @Test
    public void getTexttc() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/about.html");
        By p = new By.ByCssSelector("section>p");
        getText(p);
    }

    @Test
    public void getpropertytc() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        type(username, "admin");
        getproperty(username, "value");
        getAttribute(username, "value");
    }

    @Test
    public void shadowdom() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("http://watir.com/examples/shadow_dom.html");
        By shadowHost = By.id("shadow_host");
        By input = By.cssSelector("[type=\"text\"]");
        driver.findElement(shadowHost).getShadowRoot().findElement(input).sendKeys("nada");

    }


    public String getproperty(By by, String preperty) {
        String property = findElement(by).getDomProperty(preperty);
        System.out.println(property);
        return property;
    }

    public String getAttribute(By by, String attribute) {
        String attr = findElement(by).getDomProperty(attribute);
        System.out.println(attr);
        return attr;
    }


    public String getText(By by) {
        String text = driver.findElement(by).getText();
        System.out.println(text);
        return text;
    }

    public void clicking(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void UploadFile(By by, String filepath) {
        String userHome = System.getProperty("user.dir");
        System.out.println(userHome);
        findElement(by).sendKeys(userHome + File.separator + filepath);
    }


    public void clear(By by) {
        driver.findElement(by).clear();
    }


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

}

