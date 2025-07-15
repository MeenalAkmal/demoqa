package demoqatests;

import demoqapages.SelectablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectableTest {

    @Test
    public void testSelectableListAndGrid() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/selectable");
        driver.manage().window().maximize();

        SelectablePage page = new SelectablePage(driver);

       
        page.clickListItem(0);
        Thread.sleep(1000);
        WebElement firstItem = page.getListItems().get(0);
        boolean listSelected = firstItem.getAttribute("class").contains("active");
        System.out.println("List item 'Cras justo odio' selected: " + listSelected);
        assertTrue(listSelected, "List item should be selected.");

       
        page.openGridTab();
        Thread.sleep(1000);

        page.clickGridItem(4); 
        Thread.sleep(1000);
        WebElement gridItem = page.getGridItems().get(4);
        boolean gridSelected = gridItem.getAttribute("class").contains("active");
        System.out.println("Grid item 'Two' selected: " + gridSelected);
        assertTrue(gridSelected, "Grid item 'Two' should be selected.");

        System.out.println(" Selectable test completed successfully.");
        driver.quit();
    }
}

