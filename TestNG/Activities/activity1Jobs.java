package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity1Jobs {
        WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Create the Actions object
 //       Actions builder = new Actions(driver);
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void compareText(){
        String pageTitle = driver.getTitle();
        System.out.print("The tile of the page is:" + pageTitle);
        Assert.assertEquals("Alchemy Jobs – Job Board Application", pageTitle);
    }

    @AfterClass
    public void afterClass(){
         driver.close();

    }
}