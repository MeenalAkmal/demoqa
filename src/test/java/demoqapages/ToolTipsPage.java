package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolTipsPage {
    WebDriver driver;

    public ToolTipsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By toolTipButton = By.id("toolTipButton");
    private By toolTipTextBox = By.id("toolTipTextField");

    // Get elements
    public WebElement getToolTipButton() {
        return driver.findElement(toolTipButton);
    }

    public WebElement getToolTipTextBox() {
        return driver.findElement(toolTipTextBox);
    }

    // Common tooltip container
    public WebElement getTooltipContent() {
        return driver.findElement(By.cssSelector(".tooltip-inner"));
    }
}
