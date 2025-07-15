
package demoqatests;

import demoqapages.BookStorePage;
import demoqapages.BookDetailsPage;
import demoqapages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class BookDetailsTest {
    WebDriver driver;
    BookStorePage bookStorePage;
    BookDetailsPage bookDetailsPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Login
        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        // Go to book store
        driver.get("https://demoqa.com/books");
        bookStorePage = new BookStorePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBookDetailsPageBehavior() throws InterruptedException {
        // Step 1: Click first book
        bookStorePage.clickFirstBook();
        Thread.sleep(3000); // wait for navigation

        // Step 2: Check if book details page has content
        bookDetailsPage = new BookDetailsPage(driver);
        String currentUrl = driver.getCurrentUrl();
        String titleText = bookDetailsPage.getBookTitle();
        String pageHeader = bookDetailsPage.getPageHeading();

        System.out.println(" Current URL: " + currentUrl);
        System.out.println(" Title Text: " + titleText);
        System.out.println(" Page Header: " + pageHeader);
        assertFalse(titleText.isEmpty() && pageHeader.isEmpty(), "Book details are missing");


        if (titleText.isEmpty() && pageHeader.isEmpty()) {
            System.out.println(" Book details are missing or not rendered.");
            
        } else {
            System.out.println(" Book details page loaded successfully.");
            assertTrue(titleText.contains("Git Pocket Guide") || pageHeader.contains("Book Store"), "Book title/header not as expected.");
        }
    }
}
