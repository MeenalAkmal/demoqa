package demoqatests;

import demoqapages.SortablePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SortableTest {

    @Test
    public void testSortableListAndGrid() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        SortablePage sortablePage = new SortablePage(driver);
        Actions actions = new Actions(driver);

        // Sortable List
        List<WebElement> beforeList = sortablePage.getListItems();
        String firstBefore = beforeList.get(0).getText();
        String secondBefore = beforeList.get(1).getText();

        // Swap first and second
        actions.clickAndHold(beforeList.get(0))
                .moveToElement(beforeList.get(1))
                .release()
                .perform();

        Thread.sleep(1000);

        List<WebElement> afterList = sortablePage.getListItems();
        String firstAfter = afterList.get(0).getText();
        String secondAfter = afterList.get(1).getText();

        System.out.println("Before Sort: " + firstBefore + ", " + secondBefore);
        System.out.println("After Sort: " + firstAfter + ", " + secondAfter);

        assertNotEquals(firstBefore, firstAfter, "List order should change after sorting");

        // Switch to Grid Tab
        sortablePage.clickGridTab();
        Thread.sleep(1000);

        List<WebElement> gridItems = sortablePage.getGridItems();
        System.out.println("Grid Items:");
        for (WebElement item : gridItems) {
            System.out.print(item.getText() + " ");
        }

        driver.quit();
    }
}
