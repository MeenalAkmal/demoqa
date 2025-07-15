
package demoqatests;

import demoqapages.DatePickerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatePickerTest {

    @Test
    public void testDatePickerInputs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker");

        DatePickerPage datePicker = new DatePickerPage(driver);

        // Test setting date only
        String expectedDate = "07/11/2025";  // Must match the format
        datePicker.setDate(expectedDate);
        Thread.sleep(1000);
        String actualDate = datePicker.getDate();
        System.out.println("✅ Date Selected: " + actualDate);
        assertEquals(expectedDate, actualDate, "Date does not match expected format!");

        // Test setting date and time
        String expectedDateTime = "July 11, 2025 5:30 PM";  // Format must match calendar
        datePicker.setDateTime(expectedDateTime);
        Thread.sleep(1000);
        String actualDateTime = datePicker.getDateTime();
        System.out.println("✅ DateTime Selected: " + actualDateTime);
        assertEquals(expectedDateTime, actualDateTime, "DateTime mismatch!");

        driver.quit();
    }
}

