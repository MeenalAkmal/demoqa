package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage {
    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By expandAllButton = By.cssSelector("button[title='Expand all']");
    private By collapseAllButton = By.cssSelector("button[title='Collapse all']");
    private By homeCheckbox = By.cssSelector("label[for='tree-node-home']");
    private By resultText = By.id("result");

    // Actions
    public void expandAll() {
        driver.findElement(expandAllButton).click();
    }

    public void collapseAll() {
        driver.findElement(collapseAllButton).click();
    }

    public void clickHomeCheckbox() {
        driver.findElement(homeCheckbox).click();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
