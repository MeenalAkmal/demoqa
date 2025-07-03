
package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSlider extends BaseTest {

    @Test
    public void testSliderValue() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        // Move slider to the right (each step = 0.5)
        for (int i = 0; i < 10; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(100);  // Short pause so browser updates
        }

        // Get value
        WebElement value = driver.findElement(By.id("range"));
        String sliderValue = value.getText();

        System.out.println("Slider value: " + sliderValue);

        assertEquals("5", sliderValue, "Slider should be at max value (5)");
    }
}
