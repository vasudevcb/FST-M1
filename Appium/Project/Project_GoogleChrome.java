package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Project_GoogleChrome {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
//        driver.get("https://v1.training-support.net/selenium");
    }

    // Test method
    @Test
    public void chromeTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View")));

        // Find all the option elements on the page
        List<WebElement> optionElements = driver.findElements(AppiumBy.className("android.view.View"));

        // Scroll using UiScrollable
//        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List Elements get added at runtime!\")"));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
//        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Task");
        driver.findElement(AppiumBy.xpath("//*[@class='android.widget.EditText']")).sendKeys("Task");
        driver.findElement(AppiumBy.xpath("//*[@class='android.widget.EditText']/following-sibling::android.widget.Button")).click();
//    android.widget.Button")).click();
//        driver.findElement(AppiumBy.xpath("//*[contains(@class='android.widget.EdditText')]/" +
//                "following-sibling::/*[contains(@class='android.widget.Button')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));

        List<WebElement> todoList = driver.findElements(AppiumBy.xpath("//android.widget.ListView/android.view.View"));
        System.out.print("The number of to do items are "+todoList.size());

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Task']")));
        //To click on Checkbox
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Task']/preceding-sibling::android.widget.CheckBox")).click();
        //To delete the selected item
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Task']/following-sibling::android.widget.Button")).click();
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}