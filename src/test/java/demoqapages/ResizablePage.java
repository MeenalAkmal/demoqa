package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResizablePage {
    WebDriver driver;

    public ResizablePage(WebDriver driver) {
        this.driver = driver;
    }

    private By restrictedBox = By.id("resizableBoxWithRestriction");
    private By restrictedHandle = By.cssSelector("#resizableBoxWithRestriction .react-resizable-handle");
    private By unrestrictedBox = By.id("resizable");
    private By unrestrictedHandle = By.cssSelector("#resizable .react-resizable-handle");

    public WebElement getRestrictedBox() {
        return driver.findElement(restrictedBox);
    }

    public WebElement getRestrictedHandle() {
        return driver.findElement(restrictedHandle);
    }

    public WebElement getUnrestrictedBox() {
        return driver.findElement(unrestrictedBox);
    }

    public WebElement getUnrestrictedHandle() {
        return driver.findElement(unrestrictedHandle);
    }
}
