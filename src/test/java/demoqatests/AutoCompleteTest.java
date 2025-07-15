package demoqatests;

import demoqapages.AutoCompletePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoCompleteTest {

    @Test
    public void testAutoCompleteInputs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/auto-complete");

        AutoCompletePage page = new AutoCompletePage(driver);

        // Test multiple colors
        page.enterMultipleColors("Red", "Green");
        Thread.sleep(2000);
        String multipleText = page.getMultipleInputText();
        System.out.println("✅ Multiple Input Value: " + multipleText);
        assertEquals("Red", multipleText); // Only first item returned from getText()

        // Test single color
        page.enterSingleColor("Blue");
        Thread.sleep(2000);
        String singleText = page.getSingleInputText();
        System.out.println("✅ Single Input Value: " + singleText);
        assertEquals("Blue", singleText);

        driver.quit();
    }
}
