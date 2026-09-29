package QA;

import org.openqa.selenium.WebDriver;

public class LandingPage extends BaseTest {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }
}
