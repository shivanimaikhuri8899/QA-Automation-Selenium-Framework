package QA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v143.page.model.Screenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LoginPage {

   /* @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[1][2];
        data[0][0]="rahulshettyacademy";
        data[0][1]="Learning@830$3mK2";
        return data;
    }*/
   @DataProvider(name="test")
   public Object[][] getData() throws FileNotFoundException, IOException {
       DataFormatter formatter=new DataFormatter();
       FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Sheet.xlsx");
       XSSFWorkbook wb=new XSSFWorkbook(fis);
       XSSFSheet sheet=wb.getSheetAt(0);
       int rowCount=sheet.getPhysicalNumberOfRows();
       XSSFRow row=sheet.getRow(1);
       int colCount=row.getLastCellNum();
       Object[][] object=new Object[rowCount-1][colCount];
       for(int i=0;i<rowCount-1;i++){
           //row=sheet.getRow(i+1);
           for(int j=0;j<colCount;j++){
               XSSFCell cell=row.getCell(j);
               object[i][j]=formatter.formatCellValue(cell);
           }
       }
       return object;
   }


    @Test(dataProvider = "test", retryAnalyzer = Retry.class)
    public void Task(String username,String password) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File setFile=new File("");
        FileUtils.copyFile(src,setFile);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='user']")).click();
        driver.findElement(By.id("okayBtn")).click();
        Select select = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
        select.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));
        List<WebElement> list = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
        for (int i = 0; i < list.size(); i++) {
            WebElement product = list.get(i);
            product.click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("button[class='btn btn-success']:nth-child(1)")).isDisplayed());
        driver.quit();
    }
}
