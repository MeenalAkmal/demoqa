package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {
    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By output = By.id("output");

    // Actions
    public void enterFullName(String name) {
        driver.findElement(fullNameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddressInput).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(permanentAddressInput).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getOutputText() {
        return driver.findElement(output).getText();
    }
}