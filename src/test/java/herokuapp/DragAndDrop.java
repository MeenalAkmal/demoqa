package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends BaseTest {

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        // Use Actions class for drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();

        // Wait for observation
        Thread.sleep(3000);
    }
}
