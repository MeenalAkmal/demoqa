package demoqapages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PracticeFormPage {
    WebDriver driver;
    WebDriverWait wait;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By genderMale = By.xpath("//label[text()='Male']");
    By userMobile = By.id("userNumber");
    By subjectsInput = By.id("subjectsInput");
    By hobbyReading = By.xpath("//label[text()='Reading']");
    By uploadPicture = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By stateDropdown = By.id("react-select-3-input");
    By cityDropdown = By.id("react-select-4-input");
    By submitBtn = By.id("submit");

    // Actions
    public void fillForm(String fName, String lName, String email, String mobile, String subject, String picturePath, String address, String state, String city) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(genderMale).click();
        driver.findElement(userMobile).sendKeys(mobile);

        WebElement subjectField = driver.findElement(subjectsInput);
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);

        driver.findElement(hobbyReading).click();
        driver.findElement(uploadPicture).sendKeys(picturePath);
        driver.findElement(currentAddress).sendKeys(address);

        // Wait and send state
        WebElement stateField = wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        stateField.sendKeys(state);
        stateField.sendKeys(Keys.ENTER);

        // Wait and send city
        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ENTER);
    }

        public void submitForm() {
            WebElement submit = driver.findElement(submitBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        }

    }


