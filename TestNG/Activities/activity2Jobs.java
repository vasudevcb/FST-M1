package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class activity2Jobs {
     WebDriver driver;

     @BeforeClass
    public void openBrowser(){
         WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         driver.get("https://alchemy.hguy.co/jobs/");
     }

     @Test
    public void findTxt(){
         WebElement getHeader = driver.findElement(By.className("entry-title"));
         String getHeaderTxt = getHeader.getText();
         System.out.print(getHeaderTxt);
         Assert.assertEquals("Welcome to Alchemy Jobs", getHeaderTxt);
     }
     @AfterClass
    public void closeBrowser(){
         driver.close();
     }
}
