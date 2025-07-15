package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage {

    WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By doubleClickBtn = By.id("doubleClickBtn");
    By rightClickBtn = By.id("rightClickBtn");
    By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By dynamicClickMessage = By.id("dynamicClickMessage");

    // Actions
    public WebElement getDoubleClickButton() {
        return driver.findElement(doubleClickBtn);
    }

    public WebElement getRightClickButton() {
        return driver.findElement(rightClickBtn);
    }

    public WebElement getDynamicClickButton() {
        return driver.findElement(dynamicClickBtn);
    }

    public String getDoubleClickMessage() {
        return driver.findElement(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return driver.findElement(rightClickMessage).getText();
    }

    public String getDynamicClickMessage() {
        return driver.findElement(dynamicClickMessage).getText();
    }
}

