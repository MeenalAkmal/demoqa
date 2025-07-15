package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicPropertiesPage {

    WebDriver driver;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEnableAfterButton() {
        return driver.findElement(By.id("enableAfter"));
    }

    public WebElement getVisibleAfterButton() {
        return driver.findElement(By.id("visibleAfter"));
    }

    public WebElement getColorChangeButton() {
        return driver.findElement(By.id("colorChange"));
    }
}

