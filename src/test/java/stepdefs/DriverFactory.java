package stepdefs;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class DriverFactory {

    private WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver getDriver(){
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public WebDriver setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
