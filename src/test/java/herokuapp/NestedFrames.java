package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NestedFrames extends BaseTest {

    @Test
    public void testNestedFrames() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

       
        Thread.sleep(3000); // Just to observe
    }
}

