package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage {
    private WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addButton = By.id("addNewRecordButton");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By age = By.id("age");
    private By salary = By.id("salary");
    private By department = By.id("department");
    private By submitButton = By.id("submit");
    private By table = By.className("rt-table");

    // Actions
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(userEmail).sendKeys(value);
    }

    public void enterAge(String value) {
        driver.findElement(age).sendKeys(value);
    }

    public void enterSalary(String value) {
        driver.findElement(salary).sendKeys(value);
    }

    public void enterDepartment(String value) {
        driver.findElement(department).sendKeys(value);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getTableText() {
        return driver.findElement(table).getText();
    }
}

