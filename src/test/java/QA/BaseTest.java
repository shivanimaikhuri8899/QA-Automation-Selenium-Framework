package QA;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    LandingPage page;

    public WebDriver initializeDriver() throws FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//QA//" +
                "Resources.properties");
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        //if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
           // if (browserName.contains("headless")) {
         //       options.addArguments("headless");
         //   }
            driver = new ChromeDriver(options);

        /*    if (browserName.contains("headless")) {
                driver.manage().window().setSize(new Dimension(1440,900));//full screen
            }

        }
        if (browserName.contains("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new FirefoxDriver(options);
        }*/
        return driver;
    }
    public LandingPage launchApp() throws FileNotFoundException {
        driver=initializeDriver();
        LandingPage landingPage=new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

}