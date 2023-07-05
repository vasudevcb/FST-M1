package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class activity8Jobs {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/wp-login.php");
        driver.manage().window().maximize();
    }
    @Test
    public void loginPage(){
//        Actions builder = new Actions(driver);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement userPwd = driver.findElement(By.id("user_pass"));
        userName.sendKeys("root");
        userPwd.sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement userLogin = driver.findElement(By.id("wpadminbar"));
        String userValue = userLogin.findElement(By.xpath("//ul[@id='wp-admin-bar-top-secondary']//a")).getText();
        if(userValue.contains("root")){
            System.out.print("User logged in Successfully");
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
