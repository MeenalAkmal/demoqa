package demoqatests;

import demoqapages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTest {

    @Test
    public void testPracticeFormSubmission() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        PracticeFormPage formPage = new PracticeFormPage(driver);

        // === Test data ===
        String fname = "Meenal";
        String lname = "Akmal";
        String email = "meenal@example.com";

        formPage.fillForm(
                fname,
                lname,
                email,
                "03123456789",
                "Computer Science",
                "C:\\Users\\meena\\Downloads\\testupload.jpeg",  // ✅ Adjust path correctly
                "123, Gulberg, Lahore",
                "NCR",
                "Delhi"
        );

        formPage.submitForm();

        //  Assertion: Wait for modal and check it contains name or email
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        String modalText = modal.getText();
        System.out.println(" Modal Text:\n" + modalText);

        // Assert modal contains submitted values
        assertTrue(modalText.contains(fname), " First name not in modal!");
        assertTrue(modalText.contains(email), " Email not in modal!");

        Thread.sleep(2000);
        driver.quit();
    }
}
