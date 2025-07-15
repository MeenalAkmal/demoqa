package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage {
    private WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By homeLink = By.id("simpleLink");
    private By dynamicHomeLink = By.id("dynamicLink");

    private By createdLink = By.id("created");
    private By noContentLink = By.id("no-content");
    private By movedLink = By.id("moved");
    private By badRequestLink = By.id("bad-request");
    private By unauthorizedLink = By.id("unauthorized");
    private By forbiddenLink = By.id("forbidden");
    private By notFoundLink = By.id("invalid-url");

    private By linkResponse = By.id("linkResponse");

    // Methods to click new tab links
    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }

    public void clickDynamicHomeLink() {
        driver.findElement(dynamicHomeLink).click();
    }

    // Methods to click API links
    public void clickCreated() {
        driver.findElement(createdLink).click();
    }

    public void clickNoContent() {
        driver.findElement(noContentLink).click();
    }

    public void clickMoved() {
        driver.findElement(movedLink).click();
    }

    public void clickBadRequest() {
        driver.findElement(badRequestLink).click();
    }

    public void clickUnauthorized() {
        driver.findElement(unauthorizedLink).click();
    }

    public void clickForbidden() {
        driver.findElement(forbiddenLink).click();
    }

    public void clickNotFound() {
        driver.findElement(notFoundLink).click();
    }

    // Get API response text
    public String getLinkResponseText() {
        WebElement response = driver.findElement(linkResponse);
        return response.isDisplayed() ? response.getText() : "";
    }
}

