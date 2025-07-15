
package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraggablePage {

    WebDriver driver;

    public DraggablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Switch to a sub-tab
    public void switchToTab(String tabName) {
        driver.findElement(By.xpath("//a[text()='" + tabName + "']")).click();
    }

    // 1. Simple tab
    public WebElement getSimpleDraggableBox() {
        return driver.findElement(By.id("dragBox"));
    }

    // 2. Axis Restricted
    public WebElement getOnlyXBox() {
        return driver.findElement(By.id("restrictedX"));
    }

    public WebElement getOnlyYBox() {
        return driver.findElement(By.id("restrictedY"));
    }

    // 3. Container Restricted
    public WebElement getContainedBox() {
        return driver.findElement(By.cssSelector("#containmentWrapper #draggable"));
    }

    public WebElement getTextBox() {
        return driver.findElement(By.cssSelector("#draggablContainer .draggable.ui-widget-content.ui-draggable.ui-draggable-handle:nth-child(6)"));
    }

    // 4. Cursor Style
    public WebElement getCenterBox() {
        return driver.findElement(By.id("cursorCenter"));
    }

    public WebElement getTopLeftBox() {
        return driver.findElement(By.id("cursorTopLeft"));
    }

    public WebElement getBottomBox() {
        return driver.findElement(By.id("cursorBottom"));
    }
}
