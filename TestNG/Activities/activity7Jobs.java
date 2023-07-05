package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class activity7Jobs {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
    }

    @Test
    public void findBrowserElement(){
        driver.findElement(By.xpath("//li[@id='menu-item-26']/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement yourEmailID = driver.findElement(By.xpath("//input[@id='create_account_email']"));
        yourEmailID.clear();
        yourEmailID.sendKeys("test8@yahoo.com");
        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job_title']"));
        jobTitle.clear();
        jobTitle.sendKeys("Software Tester");
        WebElement jobLocation = driver.findElement(By.xpath("//input[@id='job_location']"));
        jobLocation.clear();
        jobLocation.sendKeys("India");
        WebElement jobType = driver.findElement(By.id("job_type")); //By.xpath("//select[@id='job_types']"));
        Select jobTypeSelect = new Select(jobType);
        jobTypeSelect.selectByValue("3");
        driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")).click();
        driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")).sendKeys("Testing");
        WebElement appEmailUrl = driver.findElement(By.id("application"));
        appEmailUrl.clear();
        appEmailUrl.sendKeys("test@gmail.com");
        // Company Details
        WebElement cmpName = driver.findElement(By.xpath("//input[@id='company_name']"));
        cmpName.clear();
        cmpName.sendKeys("IBM");
        WebElement cmpWebsite = driver.findElement(By.xpath("//input[@id='company_website']"));
        cmpWebsite.clear();
        cmpWebsite.sendKeys("www.ibm.com/india");
        WebElement cmpTagLine = driver.findElement(By.xpath("//input[@id='company_tagline']"));
        cmpTagLine.clear();
        cmpTagLine.sendKeys("The Big BLUE");
        WebElement cmpVideo = driver.findElement(By.xpath("//input[@id='company_video']"));
        cmpVideo.clear();
        cmpVideo.sendKeys("www.ibm.com");
        WebElement cmpTwitter = driver.findElement(By.xpath("//input[@id='company_twitter']"));
        cmpTwitter.clear();
        cmpTwitter.sendKeys("ibmtwiter@ibm.com");
        WebElement cmpLogo = driver.findElement(By.xpath("//input[@id='company_logo']"));
        cmpLogo.sendKeys("C:\\Users\\022346744\\Desktop\\logo.jpg");
        WebElement inputSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        inputSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        WebElement submitListing = driver.findElement(By.xpath("//input[@id='job_preview_submit_button']"));
        submitListing.click();

        // After Submitting the data re-verify
        driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));;
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        WebElement searchKeyword = driver.findElement(By.xpath("//div[@class='search_keywords']/input[@id='search_keywords']"));
        searchKeyword.clear();
        searchKeyword.sendKeys("Software Tester");
        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='search_submit']/input[@type='submit']"));
        searchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Search completed')]")));
        WebElement postjobListing = driver.findElement(By.xpath("//ul[@class='job_listings']"));
        String searchVal="software tester";
        List<WebElement> allElements1 = postjobListing.findElements(By.tagName("li"));
        for(WebElement li : allElements1){
            if(li.getText().toLowerCase().contains(searchVal)) {
                System.out.print("The Job is posted successfully");
                break;
            }
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}