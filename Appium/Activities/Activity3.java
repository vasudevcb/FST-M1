package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.miui.calculator");
        options.setAppActivity(".cal.CalculatorActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test(priority = 1)
    public void additionTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_plus_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_9_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();

        // Assertion
        Assert.assertEquals(result, "= 14");
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_c_s")).click();
    }

    // Test method
    @Test(priority = 2)
    public void subtractTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_0_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_minus_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();

        // Assertion
        Assert.assertEquals(result, "= 5");
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_c_s")).click();
    }

    // Test method
    @Test(priority = 3)
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"multiply\"]")).click();
//        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_0_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_0_s")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();

        // Assertion
        Assert.assertEquals(result, "= 500");
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_c_s")).click();
    }

    // Test method
    @Test(priority = 4)
    public void divideTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_0_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_div_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_2_s")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();

        // Assertion
        Assert.assertEquals(result, "= 5");
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_c_s")).click();
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}