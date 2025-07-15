package demoqatests;

import demoqapages.DynamicPropertiesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicPropertiesTest {

    @Test
    public void testDynamicProperties() throws InterruptedException {
    	
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");

        DynamicPropertiesPage page = new DynamicPropertiesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //  1. Wait for 'Enable After' button
        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(page.getEnableAfterButton()));
        assertTrue(enableButton.isEnabled(), " 'Enable After' button is NOT enabled after wait!");
        System.out.println(" 'Enable After' button is enabled.");

        //  2. Wait for 'Visible After' button
        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOf(page.getVisibleAfterButton()));
        assertTrue(visibleButton.isDisplayed(), " 'Visible After' button is NOT visible after wait!");
        System.out.println(" 'Visible After' button is visible.");

        //  3. Check if color of button changes
        WebElement colorBtn = page.getColorChangeButton();
        String before = colorBtn.getCssValue("color");
        Thread.sleep(6000); // Wait for color change (takes around 5 sec)
        String after = colorBtn.getCssValue("color");

        System.out.println(" Color before: " + before);
        System.out.println(" Color after : " + after);

        assertNotEquals(before, after, " Button color did NOT change!");
        System.out.println(" Button color changed successfully.");

        driver.quit();
    }
}


