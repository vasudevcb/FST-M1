package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Project_GoogleTasks {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Test method
    @Test
    public void taskTest() {
        // Find and click on Create New Task
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")
        ));

        // Find the element to add Task name
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Google Tasks");

        // Wait for Save button enable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        // Wait for the Task to be saved and listed
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_name")));

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")
        ));

        // Find the element to add Google Keep
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Google Keep");

        // Wait for Save button enable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/snackbar_text")));
        // Wait for the Task page to open
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/edit_title")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_list")));
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Google Keep\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/edit_details")));
        // Wait for the add Task details screens
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/edit_details")).sendKeys("Complete the task");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/edit_due_date_hint")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/month_view")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"20 July 2023\"]"));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/dtp_done")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/edit_subtasks_add_label")));
//       driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/edit_subtasks_add_label")).click();
//        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/subtask_title")).sendKeys("Sub Task");


        // Mark the task as complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/edit_task_complete_button")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/edit_task_complete_button")).click();

        //Assert
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_list")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/expand")).click();
        String compTask = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
        Assert.assertEquals(compTask, "Google Keep");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}