package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By mainItem2 = By.xpath("//a[text()='Main Item 2']");
    private By subSubList = By.xpath("//a[text()='SUB SUB LIST »']");
    private By subSubItem2 = By.xpath("//a[text()='Sub Sub Item 2']");

    // Actions
    public WebElement getMainItem2() {
        return driver.findElement(mainItem2);
    }

    public WebElement getSubSubList() {
        return driver.findElement(subSubList);
    }

    public WebElement getSubSubItem2() {
        return driver.findElement(subSubItem2);
    }
}
