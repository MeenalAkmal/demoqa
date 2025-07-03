package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicContent extends BaseTest {

    @Test
    public void testContentChangesOnRefresh() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_content");

        // Locate and store the first block of content
        WebElement contentBefore = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]"));
        String textBefore = contentBefore.getText();
        System.out.println("Before Refresh: " + textBefore);

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(6000);

        
        WebElement contentAfter = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]"));
      String textAfter = contentAfter.getText();
          System.out.println("After Refresh: " + textAfter);

         
        assertNotEquals(textBefore, textAfter, "Content should change after refresh");
    }
}
