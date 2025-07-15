package demoqatests;

import demoqabasetest.basetest;
import demoqapages.CheckBoxPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBoxTest extends basetest {

    @Test
    public void testCheckboxSelection() {
        driver.get("https://demoqa.com/checkbox");

        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();
        checkBoxPage.clickHomeCheckbox();

        // Wait for result to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));


        String result = checkBoxPage.getResultText();
        System.out.println(" Selected Result: " + result);

        // Assertion
        assertTrue(result.toLowerCase().contains("home"), " Expected 'home' to be in the result text.");
    }
}

