package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity5Jobs {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void findBrowserElement(){
        driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
//        System.out.print(driver.findElement(By.tagName("h1")).getText());
        String getJobTitle = driver.getTitle();
        System.out.print("The page title is: " + getJobTitle);
        Assert.assertEquals("Jobs – Alchemy Jobs", getJobTitle);
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
