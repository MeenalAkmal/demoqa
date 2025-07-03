
package herokuapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseTest {
	
@Test
public void testDropdownSelection() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dropdown");

    WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    Select dropdown = new Select(dropdownElement);

    dropdown.selectByVisibleText("Option 1");
    WebElement selected = dropdown.getFirstSelectedOption();
    assertEquals("Option 1", selected.getText());

    System.out.println("✔ First Selected: " + selected.getText());
    Thread.sleep(3000);  // Observe "Option 1"

    dropdown.selectByIndex(2); // selects "Option 2"
    WebElement selected2 = dropdown.getFirstSelectedOption();
    System.out.println("✔ Second Selected: " + selected2.getText());
    Thread.sleep(3000);  // Observe "Option 2"
}
}

