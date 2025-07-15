
package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DroppablePage {

    WebDriver driver;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- TAB SWITCHING ----------------
    public void switchToTab(String tabName) {
        String xpath = "//a[text()='" + tabName + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    // ---------------- 1. SIMPLE ----------------
    public WebElement getDragMeBox() {
        return driver.findElement(By.id("draggable"));
    }

    public WebElement getDropHereBox() {
        return driver.findElement(By.id("droppable"));
    }

    public String getDropResultText() {
        return driver.findElement(By.id("droppable")).getText();
    }

    // ---------------- 2. ACCEPT ----------------
    public WebElement getAcceptable() {
        return driver.findElement(By.id("acceptable"));
    }

    public WebElement getNotAcceptable() {
        return driver.findElement(By.id("notAcceptable"));
    }

    public WebElement getAcceptDropBox() {
        return driver.findElement(By.cssSelector("#acceptDropContainer #droppable"));
    }

    public String getAcceptDropText() {
        return getAcceptDropBox().getText();
    }

    // ---------------- 3. PREVENT PROPAGATION ----------------
    public WebElement getDragBoxPropagation() {
        return driver.findElement(By.id("dragBox"));
    }

    public WebElement getOuterDropBox() {
        return driver.findElement(By.id("notGreedyDropBox"));
    }

    public WebElement getInnerDropBox() {
        return driver.findElement(By.id("notGreedyInnerDropBox"));
    }

    public String getOuterDropText() {
        return getOuterDropBox().getText();
    }

    public String getInnerDropText() {
        return getInnerDropBox().getText();
    }

    // ---------------- 4. REVERT DRAGGABLE ----------------
    public WebElement getWillRevert() {
        return driver.findElement(By.id("revertable"));
    }

    public WebElement getNotRevert() {
        return driver.findElement(By.id("notRevertable"));
    }

    public WebElement getRevertDropBox() {
        return driver.findElement(By.cssSelector("#revertableDropContainer #droppable"));
    }
}
