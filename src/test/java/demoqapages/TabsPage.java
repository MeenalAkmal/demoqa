package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabsPage {
    WebDriver driver;

    public TabsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Tab locators
    private By whatTab = By.id("demo-tab-what");
    private By originTab = By.id("demo-tab-origin");
    private By useTab = By.id("demo-tab-use");

    // Common tab content area
    private By activeContent = By.cssSelector("div[role='tabpanel'].fade.show.active > p");

    public void clickWhatTab() {
        driver.findElement(whatTab).click();
    }

    public void clickOriginTab() {
        driver.findElement(originTab).click();
    }

    public void clickUseTab() {
        driver.findElement(useTab).click();
    }

    public String getTabContent() {
        return driver.findElement(activeContent).getText();
    }
}
