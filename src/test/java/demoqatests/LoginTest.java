package demoqatests;

import demoqapages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    @Order(1)
    public void testValidLogin() throws InterruptedException {
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        String displayedUsername = driver.findElement(By.id("userName-value")).getText();

        assertEquals("https://demoqa.com/profile", currentUrl, "User should land on profile page");
        assertEquals("meenal", displayedUsername, "Logged in user should be 'meenal'");
        System.out.println(" Login successful with valid credentials");
    }

    @Test
    @Order(2)
    public void testLoginWithInvalidCredentials() throws InterruptedException {
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        Thread.sleep(1500);
        String errorMsg = loginPage.getErrorMessage();
        System.out.println(" Error message: " + errorMsg);
        assertTrue(errorMsg.contains("Invalid"), "Expected invalid login message");
    }

    @Test
    @Order(3)
    public void testEmptyCredentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String url = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/login", url, "Should stay on login page with empty fields");
    }

    @Test
    @Order(4)
    public void testOnlyUsernameEntered() {
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String url = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/login", url, "Should not login without password");
    }

    @Test
    @Order(5)
    public void testOnlyPasswordEntered() {
        loginPage.enterUsername("");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        String url = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/login", url, "Should not login without username");
    }

    @Test
    @Order(6)
    public void testLogoutFunctionality() throws InterruptedException {
        loginPage.enterUsername("meenal");
        loginPage.enterPassword("Abcd123!");
        loginPage.clickLogin();

        Thread.sleep(2000);
        loginPage.clickLogout();
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/login", currentUrl, "Should redirect to login after logout");
        System.out.println(" Logout successful");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


