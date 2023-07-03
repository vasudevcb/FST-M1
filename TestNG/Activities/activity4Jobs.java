package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity4Jobs {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void getHeadingTwo(){
        WebElement getH2Txt = driver.findElement(By.xpath("//div[@class='entry-content clear']"));
        System.out.print(getH2Txt.findElement(By.xpath("//h2")).getText());
        Assert.assertEquals("Quia quis non",getH2Txt.findElement(By.xpath("//h2")).getText());
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
