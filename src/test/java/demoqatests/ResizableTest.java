package demoqatests;

import demoqapages.ResizablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResizableTest {

    @Test
    public void testResizeBoxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/resizable");
        driver.manage().window().maximize();

        ResizablePage page = new ResizablePage(driver);
        Actions actions = new Actions(driver);

        // ========== RESIZABLE BOX WITH RESTRICTIONS ==========
        WebElement box1 = page.getRestrictedBox();
        Dimension beforeResize1 = box1.getSize();
        WebElement handle1 = page.getRestrictedHandle();

        actions.dragAndDropBy(handle1, 50, 50).perform();
        Thread.sleep(1000);
        Dimension afterResize1 = box1.getSize();

        System.out.println(" Restricted box - Before: " + beforeResize1 + ", After: " + afterResize1);
        assertTrue(afterResize1.getHeight() > beforeResize1.getHeight(), "Restricted box height should increase");

        // ========== RESIZABLE BOX WITHOUT RESTRICTIONS ==========
        WebElement box2 = page.getUnrestrictedBox();
        Dimension beforeResize2 = box2.getSize();
        WebElement handle2 = page.getUnrestrictedHandle();

        actions.dragAndDropBy(handle2, 80, 60).perform();
        Thread.sleep(1000);
        Dimension afterResize2 = box2.getSize();

        System.out.println(" Unrestricted box - Before: " + beforeResize2 + ", After: " + afterResize2);
        assertTrue(afterResize2.getWidth() > beforeResize2.getWidth(), "Unrestricted box width should increase");

        driver.quit();
    }
}
