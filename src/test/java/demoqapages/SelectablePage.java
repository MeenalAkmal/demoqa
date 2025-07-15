package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SelectablePage {
    WebDriver driver;

    public SelectablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By listItems = By.cssSelector("#verticalListContainer li");
    private By gridTab = By.id("demo-tab-grid");
    private By gridItems = By.cssSelector("#gridContainer .list-group-item.active");

    // Actions
    public List<WebElement> getListItems() {
        return driver.findElements(listItems);
    }

    public void clickListItem(int index) {
        getListItems().get(index).click();
    }

    public void openGridTab() {
        driver.findElement(gridTab).click();
    }

    public List<WebElement> getGridItems() {
        return driver.findElements(By.cssSelector("#gridContainer .list-group-item"));
    }

    public void clickGridItem(int index) {
        getGridItems().get(index).click();
    }
}
