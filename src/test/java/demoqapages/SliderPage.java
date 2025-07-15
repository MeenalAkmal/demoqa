package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage {
    WebDriver driver;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    By slider = By.cssSelector("input[type='range']");
    By sliderValue = By.id("sliderValue");

    public void moveSliderToRight(int offset) {
        WebElement sliderElement = driver.findElement(slider);
        Actions action = new Actions(driver);
        action.clickAndHold(sliderElement).moveByOffset(offset, 0).release().perform();
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getAttribute("value");
    }
}
