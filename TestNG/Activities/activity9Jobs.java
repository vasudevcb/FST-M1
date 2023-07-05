package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class activity9Jobs {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();
    }
    @Test
    public void loginPage(){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Identify the username and password field
        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement userPwd = driver.findElement(By.id("user_pass"));
        userName.clear();
        userPwd.clear();
        userName.sendKeys("root");
        userPwd.sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        // wait for the page to load after login
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        WebElement menuList = driver.findElement(By.id("adminmenu"));

        List<WebElement> allElement = menuList.findElements(By.tagName("li"));

        for(WebElement li : allElement){
            if(li.getText().toLowerCase().contains("job listings")){
                li.click();
                break;
            }
        }

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement addNewJob = driver.findElement(By.className("page-title-action"));
        addNewJob.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='components-modal__frame components-guide edit-post-welcome-guide']")));
        WebElement closePopup = driver.findElement(By.xpath("//button[@class='components-button has-icon' and @aria-label='Close dialog']"));
        if(closePopup.isDisplayed() && closePopup.isEnabled()){
            closePopup.click();
        }

        // Fill the form that need to be publish
        WebElement positionArea = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        positionArea.clear();
        positionArea.sendKeys("Software Tester");

        WebElement companyWebsite = driver.findElement(By.xpath("//input[@id='_company_website']"));
        companyWebsite.clear();
        companyWebsite.sendKeys("www.ibm.com/india");

        WebElement companyTwiter = driver.findElement(By.xpath("//input[@id='_company_twitter']"));
        companyTwiter.clear();
        companyTwiter.sendKeys("ibm@twitter.com");

        WebElement positionFilled = driver.findElement(By.xpath("//input[@id='_filled']"));
        positionFilled.click();

        WebElement jobExpityDate = driver.findElement(By.xpath("//input[@id='_job_expires']"));
        jobExpityDate.click();
        jobExpityDate.sendKeys("August 15, 2023");
        jobExpityDate.sendKeys(Keys.TAB);

        WebElement jobLocation = driver.findElement(By.xpath("//input[@id='_job_location']"));
        jobLocation.clear();
        jobLocation.sendKeys("India");

        WebElement companyName = driver.findElement(By.xpath("//input[@id='_company_name']"));
        companyName.clear();
        companyName.sendKeys("IBM India PVT Ltd.");

        WebElement companyTag = driver.findElement(By.xpath("//input[@id='_company_tagline']"));
        companyTag.clear();
        companyTag.sendKeys("The Big Blue");

        WebElement companyVideo = driver.findElement(By.xpath("//input[@id='_company_video']"));
        companyVideo.clear();
        companyVideo.sendKeys("www.ibm.com/videos");

        WebElement companyFeature = driver.findElement(By.xpath("//input[@id='_featured']"));
        companyFeature.click();

        WebElement publish1 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
        publish1.click();

        WebElement publish2 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']"));
        publish2.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='editor-post-publish-panel__header-published' and text()='Published']")));

        //return to home page
        driver.findElement(By.xpath("//a[@class='components-button edit-post-fullscreen-mode-close has-icon']")).click();
        //click Joblisting
        driver.findElement(By.xpath("//div[@class='wp-menu-name' and text()='Job Listings']")).click();
        //Assert the job posted
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='job_position']/a[1]")).getText(),"Software Tester");
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
