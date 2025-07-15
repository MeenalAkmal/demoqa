package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SortablePage {
    WebDriver driver;

    public SortablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By listItems = By.cssSelector("#demo-tabpane-list .list-group-item");
    By gridTab = By.id("demo-tab-grid");
    By gridItems = By.cssSelector("#demo-tabpane-grid .list-group-item");

    // Get List Items
    public List<WebElement> getListItems() {
        return driver.findElements(listItems);
    }

    // Switch to Grid Tab
    public void clickGridTab() {
        driver.findElement(gridTab).click();
    }

    // Get Grid Items
    public List<WebElement> getGridItems() {
        return driver.findElements(gridItems);
    }
}
