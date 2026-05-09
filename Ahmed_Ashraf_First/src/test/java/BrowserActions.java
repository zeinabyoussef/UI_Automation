import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    //test Runner
    @Test
    public void testcase() {
        driver = new EdgeDriver();
        maximize();
        //minimize();
        // driver.get("https://www.google.com");
        navigateTo("https://www.google.com");
        navigateTo("https://www.bing.com");
        navigateback();
        navigateforword();
        // fullscreen();
        //setposition();
        //setsize(430, 932);
        getcurrenturl();
        gettitle();
        //getpagesource();
        getwindowhandle();
        //close();
        qiute();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateback() {
        driver.navigate().back();
    }

    public void navigateforword() {
        driver.navigate().forward();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void minimize() {
        driver.manage().window().minimize();
    }

    public void setposition() {
        Point point = new Point(100, 100);
        driver.manage().window().setPosition(point);
    }

    public void setsize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    public void getcurrenturl() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    public void gettitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public void getpagesource() {
        String source = driver.getPageSource();
        System.out.println(source);
    }

    public void getwindowhandle() {
        String handle = driver.getWindowHandle();
        System.out.println(handle);
    }

    public void close() {
        driver.close();
    }

    public void qiute() {
        driver.quit();
    }

    
}

