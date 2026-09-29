package QA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class E2E extends BaseTest {
    //WebDriver driver;
    @Test
    public void Flow() throws InterruptedException, FileNotFoundException {
        launchApp();
        WebElement checkbox=driver.findElement(By.id("checkBoxOption2"));
        checkbox.click();
        String chkbox=driver.findElement(By.cssSelector("label[for=benz]")).getText();
        System.out.println(chkbox);
        Select select=new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByContainsVisibleText(chkbox);
        driver.findElement(By.id("name")).sendKeys(chkbox);
        driver.findElement(By.id("alertbtn")).click();
        String statement=driver.switchTo().alert().getText();
        Assert.assertTrue(statement.contains(chkbox));
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        driver.quit();
    }

}
