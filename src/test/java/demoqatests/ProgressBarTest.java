package demoqatests;

import demoqabasetest.basetest;
import demoqapages.ProgressBarPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressBarTest extends basetest {

    @Test
    public void testProgressBarReaches100Percent() {
        driver.get("https://demoqa.com/progress-bar");
        System.out.println(" Opened Progress Bar Page");

        ProgressBarPage progressPage = new ProgressBarPage(driver);
        progressPage.clickStartButton();
        System.out.println(" Clicked Start Button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(driver -> {
            String progressText = progressPage.getProgressBarText();
            System.out.println(" Current progress: " + progressText);
            return progressText.equals("100%");
        });

        String finalText = progressPage.getProgressBarText();
        String buttonText = progressPage.getStartButtonText();

        System.out.println(" Final progress text: " + finalText);
        System.out.println(" Button text: " + buttonText);

        assertEquals("100%", finalText, " Progress bar did not reach 100%");
        assertEquals("Reset", buttonText, " Button did not change to 'Reset'");

        System.out.println(" Test PASSED. Progress bar completed successfully.");
    }
}

