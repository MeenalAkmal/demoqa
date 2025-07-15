package demoqatests;

import demoqapages.AlertsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest {

    @Test
    public void testAllAlerts() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        AlertsPage alerts = new AlertsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //  1. Simple Alert
        alerts.clickSimpleAlert();
        Alert alert = driver.switchTo().alert();
        String simpleText = alert.getText();
        System.out.println(" Simple Alert Text: " + simpleText);
        assertEquals("You clicked a button", simpleText, " Simple alert text mismatch!");
        alert.accept();

        // 2. Delayed Alert
        alerts.clickTimerAlert();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert delayedAlert = driver.switchTo().alert();
        String delayedText = delayedAlert.getText();
        System.out.println(" Delayed Alert Text: " + delayedText);
        assertEquals("This alert appeared after 5 seconds", delayedText, " Delayed alert text mismatch!");
        delayedAlert.accept();

        //  3. Confirm Alert
        alerts.clickConfirmAlert();
        Alert confirm = driver.switchTo().alert();
        String confirmText = confirm.getText();
        System.out.println(" Confirm Alert Text: " + confirmText);
        assertEquals("Do you confirm action?", confirmText, " Confirm alert text mismatch!");
        confirm.dismiss(); // or confirm.accept();

        //  4. Prompt Alert
        alerts.clickPromptAlert();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Meenal");
        prompt.accept();
        Thread.sleep(2000); // Wait for result display

        System.out.println(" Prompt input submitted.");

        // You can optionally assert the result message on the page:
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        String resultText = promptResult.getText();
        System.out.println(" Result displayed: " + resultText);
        assertEquals("You entered Meenal", resultText, " Prompt result mismatch!");

        driver.quit();
    }
}
