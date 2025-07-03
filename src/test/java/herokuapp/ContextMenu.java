package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenu extends BaseTest {

    @Test
    public void testContextMenuAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Locate the box
        WebElement box = driver.findElement(By.id("hot-spot"));

        // Perform right-click using Actions class
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

        // Switch to alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Validate alert message
        assertEquals("You selected a context menu", alertText);

        // Accept alert
        alert.accept();

        Thread.sleep(2000); // Just for visual confirmation
    }
}
