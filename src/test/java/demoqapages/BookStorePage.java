package demoqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage {
    WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    By rows = By.cssSelector(".rt-tr-group");
    By searchBox = By.id("searchBox");
    By titleHeader = By.xpath("//div[text()='Title']");
    By authorHeader = By.xpath("//div[text()='Author']");
    By publisherHeader = By.xpath("//div[text()='Publisher']");
    By bookTitles = By.cssSelector(".rt-tr-group .action-buttons a");

    public int getBookCount() {
        return driver.findElements(rows).size();
    }

    public void searchBook(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickTitleHeader() {
        driver.findElement(titleHeader).click();
    }

    public void clickAuthorHeader() {
        driver.findElement(authorHeader).click();
    }

    public void clickPublisherHeader() {
        driver.findElement(publisherHeader).click();
    }

    public String getFirstBookTitle() {
        List<WebElement> titles = driver.findElements(bookTitles);
        return titles.isEmpty() ? "" : titles.get(0).getText();
    }
    public void clickFirstBook() {
        try {
            WebElement firstBook = driver.findElement(By.cssSelector(".rt-tr-group .action-buttons a"));
            firstBook.click();
            System.out.println(" Clicked on the first book.");
        } catch (Exception e) {
            System.out.println(" Failed to click on the first book: " + e.getMessage());
        }
    }		
	}
