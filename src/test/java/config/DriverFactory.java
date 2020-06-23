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
    private static final Thread THREAD;


    static {
        WebDriverManager.chromedriver().setup();
        setDriver();
        THREAD = new Thread(driver::quit);
        Runtime.getRuntime().addShutdownHook(THREAD);
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
