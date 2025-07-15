package demoqatests;

import demoqapages.DraggablePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DraggableTest {

    @Test
    public void testDraggableTabs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dragabble");
        driver.manage().window().maximize();

        DraggablePage page = new DraggablePage(driver);
        Actions actions = new Actions(driver);

        // 🔹 1. Simple Tab
        page.switchToTab("Simple");
        WebElement box = page.getSimpleDraggableBox();
        Point before = box.getLocation();
        actions.dragAndDropBy(box, 100, 50).perform();
        Thread.sleep(1000);
        Point after = box.getLocation();
        System.out.println("Simple tab: moved from " + before + " to " + after);
        assertNotEquals(before, after, "Box should have moved");

        // 🔹 2. Axis Restricted Tab
        page.switchToTab("Axis Restricted");

        WebElement xBox = page.getOnlyXBox();
        Point xBefore = xBox.getLocation();
        actions.dragAndDropBy(xBox, 100, 0).perform();
        Thread.sleep(1000);
        Point xAfter = xBox.getLocation();
        System.out.println("Axis X: moved from " + xBefore + " to " + xAfter);
        assertNotEquals(xBefore, xAfter, "X Box should have moved horizontally");

        WebElement yBox = page.getOnlyYBox();
        Point yBefore = yBox.getLocation();
        actions.dragAndDropBy(yBox, 0, 100).perform();
        Thread.sleep(1000);
        Point yAfter = yBox.getLocation();
        System.out.println("Axis Y: moved from " + yBefore + " to " + yAfter);
        assertNotEquals(yBefore, yAfter, "Y Box should have moved vertically");

        // 🔹 3. Container Restricted Tab
        page.switchToTab("Container Restricted");
        WebElement containedBox = page.getContainedBox();
        Point cBefore = containedBox.getLocation();
        actions.dragAndDropBy(containedBox, 30, 30).perform();
        Thread.sleep(1000);
        Point cAfter = containedBox.getLocation();
        System.out.println("Container Restricted: moved from " + cBefore + " to " + cAfter);
        assertNotEquals(cBefore, cAfter, "Contained box should have moved within boundary");

        // 🔹 4. Cursor Style Tab
        page.switchToTab("Cursor Style");
        WebElement centerBox = page.getCenterBox();
        Point cenBefore = centerBox.getLocation();
        actions.dragAndDropBy(centerBox, 60, 60).perform();
        Thread.sleep(1000);
        Point cenAfter = centerBox.getLocation();
        System.out.println("Cursor Style (center): moved from " + cenBefore + " to " + cenAfter);
        assertNotEquals(cenBefore, cenAfter, "Cursor center box should have moved");

        driver.quit();
    }
}


