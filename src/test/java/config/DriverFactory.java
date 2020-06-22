package config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class DriverFactory {

    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static WebDriver setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
