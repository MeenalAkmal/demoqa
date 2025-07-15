package demoqatests;

import demoqapages.BookStorePage;
import demoqapages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTest {

    WebDriver driver;
    BookStorePage bookStorePage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Login
        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        try {
            Thread.sleep(2000);  // wait to ensure login completes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 2: Go to Book Store page
        driver.get("https://demoqa.com/books");

        // Step 3: Init Page Object
        bookStorePage = new BookStorePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBookListIsDisplayed() {
        int count = bookStorePage.getBookCount();
        assertTrue(count > 0, "Book list should not be empty");
        System.out.println(" Books loaded: " + count);
    }

    @Test
    public void testSearchFunctionality() {
        bookStorePage.searchBook("JavaScript");
        int count = bookStorePage.getBookCount();
        assertTrue(count > 0, "Search should return some results");
        System.out.println(" Search returned: " + count + " rows");
    }

  
    @Test
    public void testClickingAllSortableHeaders() throws InterruptedException {
        String titleBefore = bookStorePage.getFirstBookTitle();

        // Click Title header
        bookStorePage.clickTitleHeader();
        Thread.sleep(1000);
        String titleAfterTitleSort = bookStorePage.getFirstBookTitle();
        System.out.println("After Title Sort: " + titleAfterTitleSort);

        // Click Author header
        bookStorePage.clickAuthorHeader();
        Thread.sleep(1000);
        String titleAfterAuthorSort = bookStorePage.getFirstBookTitle();
        System.out.println("After Author Sort: " + titleAfterAuthorSort);

        // Click Publisher header
        bookStorePage.clickPublisherHeader();
        Thread.sleep(1000);
        String titleAfterPublisherSort = bookStorePage.getFirstBookTitle();
        System.out.println("After Publisher Sort: " + titleAfterPublisherSort);

        // Validate that order changes with each sort
        assertNotEquals(titleBefore, titleAfterTitleSort, "Title sort should change order");
        assertNotEquals(titleAfterTitleSort, titleAfterAuthorSort, "Author sort should change order");
        assertNotEquals(titleAfterAuthorSort, titleAfterPublisherSort, "Publisher sort should change order");
    }
}

