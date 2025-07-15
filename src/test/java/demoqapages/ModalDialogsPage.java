package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalDialogsPage {
    WebDriver driver;

    public ModalDialogsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By smallModalBtn = By.id("showSmallModal");
    By largeModalBtn = By.id("showLargeModal");

    By smallModalTitle = By.id("example-modal-sizes-title-sm");
    By largeModalTitle = By.id("example-modal-sizes-title-lg");

    By closeSmallBtn = By.id("closeSmallModal");
    By closeLargeBtn = By.id("closeLargeModal");

    // Actions
    public void openSmallModal() {
        driver.findElement(smallModalBtn).click();
    }

    public void openLargeModal() {
        driver.findElement(largeModalBtn).click();
    }

    public String getSmallModalText() {
        return driver.findElement(smallModalTitle).getText();
    }

    public String getLargeModalText() {
        return driver.findElement(largeModalTitle).getText();
    }

    public void closeSmallModal() {
        driver.findElement(closeSmallBtn).click();
    }

    public void closeLargeModal() {
        driver.findElement(closeLargeBtn).click();
    }
}
