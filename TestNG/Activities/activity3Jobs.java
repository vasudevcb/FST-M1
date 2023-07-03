package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class activity3Jobs {
    WebDriver driver;
    SoftAssert softassert = new SoftAssert();
    @BeforeClass
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void getUrl(){
        WebElement getImgSrc = driver.findElement(By.xpath("//img[contains(@class, 'attachment-large size-large wp-post-image')]"));
        String getImgURL = getImgSrc.getAttribute("src");
        System.out.print("The URL of image src is: " + getImgURL);
        softassert.assertAll();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
