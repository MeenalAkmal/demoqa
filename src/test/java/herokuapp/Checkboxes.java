package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkboxes extends BaseTest {

    @Test
    public void testCheckboxSelection() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Locate the checkboxes using XPath (no ID or name is provided)
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // Print their current state
        System.out.println("Initial - Checkbox 1 selected: " + checkbox1.isSelected());
        System.out.println("Initial - Checkbox 2 selected: " + checkbox2.isSelected());

        // ✅ Assert their expected default states
        assertFalse(checkbox1.isSelected(), "Checkbox 1 should be unchecked by default");
        assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked by default");

        // 👆 Click checkbox 1 if not selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("Checkbox 1 is now selected.");
        }

        // 👇 Uncheck checkbox 2 if selected
        if (checkbox2.isSelected()) {
            checkbox2.click();
            System.out.println("Checkbox 2 is now unselected.");
        }

        // ✅ Assert final states
        assertTrue(checkbox1.isSelected(), "Checkbox 1 should be checked now");
        assertFalse(checkbox2.isSelected(), "Checkbox 2 should be unchecked now");

        // Pause for visual confirmation
        Thread.sleep(3000);
    }
}
