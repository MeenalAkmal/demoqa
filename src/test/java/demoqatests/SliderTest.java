package demoqatests;

import demoqabasetest.basetest;
import demoqapages.SliderPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SliderTest extends basetest {

    @Test
    public void testSliderMovement() throws InterruptedException {
        driver.get("https://demoqa.com/slider");
        SliderPage sliderPage = new SliderPage(driver);

        String initialValue = sliderPage.getSliderValue();
        System.out.println("Initial Slider Value: " + initialValue);

        sliderPage.moveSliderToRight(50); // move slider to the right
        Thread.sleep(2000);

        String updatedValue = sliderPage.getSliderValue();
        System.out.println(" Slider Moved To: " + updatedValue);

        assertNotEquals(initialValue, updatedValue, "Slider value should change!");
    }
}

