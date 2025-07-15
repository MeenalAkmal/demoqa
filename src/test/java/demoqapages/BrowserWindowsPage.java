
package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage {

    WebDriver driver;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    By newTabButton = By.id("tabButton");
    By newWindowButton = By.id("windowButton");
    By messageWindowButton = By.id("messageWindowButton");

    public void clickNewTab() {
        driver.findElement(newTabButton).click();
        System.out.println(" Clicked New Tab");
    }

    public void clickNewWindow() {
        driver.findElement(newWindowButton).click();
        System.out.println(" Clicked New Window");
    }

    public void clickNewMessageWindow() {
        driver.findElement(messageWindowButton).click();
        System.out.println(" Clicked New Message Window");
    }
}
