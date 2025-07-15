package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoCompletePage {
    WebDriver driver;

    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By multipleInput = By.id("autoCompleteMultipleInput");
    private By singleInput = By.id("autoCompleteSingleInput");

    // Actions
    public void enterMultipleColors(String... colors) {
        WebElement input = driver.findElement(multipleInput);
        for (String color : colors) {
            input.sendKeys(color);
            input.sendKeys(Keys.ENTER);
        }
    }

    public void enterSingleColor(String color) {
        WebElement input = driver.findElement(singleInput);
        input.sendKeys(color);
        input.sendKeys(Keys.ENTER);
    }

    public String getMultipleInputText() {
        return driver.findElement(By.cssSelector(".auto-complete__multi-value__label")).getText();
    }

    public String getSingleInputText() {
        return driver.findElement(By.cssSelector(".auto-complete__single-value")).getText();
    }
}
