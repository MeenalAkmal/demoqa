package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddRemoveElement extends BaseTest {

    @Test
    public void testAddAndRemoveElement() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Step 1: Locate and click "Add Element" button
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click(); // ✅ This will add a "Delete" button

        // Step 2: Locate all delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));

        // Step 3: Assert that at least one Delete button is now visible
        assertTrue(deleteButtons.size() > 0, "At least one Delete button should be visible");

        // Step 4: Click the first delete button
        deleteButtons.get(0).click(); // ✅ Deletes that button

        // Step 5: Verify it's removed
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(0, deleteButtons.size(), "Delete button should be removed after clicking");

        Thread.sleep(3000); // Optional pause for demo
    }
}
