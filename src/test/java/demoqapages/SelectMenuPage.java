package demoqapages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {
    WebDriver driver;

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for different dropdowns
    By selectValue = By.id("react-select-2-input");
    By selectOne = By.id("react-select-3-input");
    By oldStyleMenu = By.id("oldSelectMenu");
    By multiSelect = By.id("react-select-4-input");

    // Actions
    public void selectValueOption(String value) {
        WebElement input = driver.findElement(selectValue);
        input.sendKeys(value);
        input.sendKeys(Keys.ENTER);
    }

    public void selectTitleOption(String title) {
        WebElement input = driver.findElement(selectOne);
        input.sendKeys(title);
        input.sendKeys(Keys.ENTER);
    }

    public void selectOldStyleOption(String color) {
        Select dropdown = new Select(driver.findElement(oldStyleMenu));
        dropdown.selectByVisibleText(color);
    }

    public void selectMultipleColors(String... colors) {
        WebElement input = driver.findElement(multiSelect);
        for (String color : colors) {
            input.sendKeys(color);
            input.sendKeys(Keys.ENTER);
        }
    }
}
