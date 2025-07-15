package demoqatests;

import demoqapages.ButtonsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonsTest {

    @Test
    public void testButtonClicks() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ButtonsPage page = new ButtonsPage(driver);
        Actions actions = new Actions(driver);

        // Wait for double click button to be visible and clickable
        WebElement doubleBtn = wait.until(ExpectedConditions.elementToBeClickable(page.getDoubleClickButton()));
        actions.doubleClick(doubleBtn).perform();
        Thread.sleep(1000);
        String doubleMsg = page.getDoubleClickMessage();
        System.out.println(" Double Click Message: " + doubleMsg);
        assertEquals("You have done a double click", doubleMsg);

        // Wait for right click button to be clickable
        WebElement rightBtn = wait.until(ExpectedConditions.elementToBeClickable(page.getRightClickButton()));
        actions.contextClick(rightBtn).perform();
        Thread.sleep(1000);
        String rightMsg = page.getRightClickMessage();
        System.out.println(" Right Click Message: " + rightMsg);
        assertEquals("You have done a right click", rightMsg);

        // Wait for dynamic click button and perform click
        WebElement dynamicBtn = wait.until(ExpectedConditions.elementToBeClickable(page.getDynamicClickButton()));
        dynamicBtn.click();
        Thread.sleep(1000);
        String dynamicMsg = page.getDynamicClickMessage();
        System.out.println(" Dynamic Click Message: " + dynamicMsg);
        assertEquals("You have done a dynamic click", dynamicMsg);

        Thread.sleep(2000); 
        driver.quit();
    }
}

