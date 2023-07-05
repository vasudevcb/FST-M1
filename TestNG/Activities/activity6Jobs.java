package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class activity6Jobs {

        WebDriver driver;
        @BeforeClass
        public void initialBrowser(){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("https://alchemy.hguy.co/jobs/");
            driver.manage().window().maximize();
        }

        @Test
        public void findBrowserElement(){
            driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            String getJobTitle = driver.getTitle();
            System.out.print("The page title is: " + getJobTitle);
//            Assert.assertEquals("Jobs – Alchemy Jobs", getJobTitle);
            WebElement searchKeyword = driver.findElement(By.xpath("//div[@class='search_keywords']/input[@id='search_keywords']"));
            searchKeyword.clear();
            searchKeyword.sendKeys("banking");
            WebElement searchBtn = driver.findElement(By.xpath("//div[@class='search_submit']/input[@type='submit']"));
            searchBtn.click();

            //To get job listing
            WebElement jobListing = driver.findElement(By.xpath("//ul[@class='job_listings']"));
            // jobListing.click();
            String searchVal="banking";
            Actions action = new Actions(driver);
            List<WebElement> allElements = jobListing.findElements(By.tagName("li"));
            for(WebElement li : allElements){
                if(li.getText().toLowerCase().contains(searchVal)) {
                    action.moveToElement(li);
                    li.click();
                    break;
               }
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            WebElement applyForJob = driver.findElement(By.xpath("//input[contains(@class,'application_button button')]"));
            applyForJob.click();
            WebElement emailID = driver.findElement(By.xpath("//a[@class='job_application_email']"));
            System.out.print("The email id is : " + emailID.getText());
        }

        @AfterClass
        public void closeBrowser(){
            driver.close();
        }
    }