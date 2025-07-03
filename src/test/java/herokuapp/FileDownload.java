package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {

    @Test
    public void testFileDownload() throws InterruptedException {
        // Set download directory inside the project folder
        String downloadDir = System.getProperty("user.dir") + "/downloads";
        new File(downloadDir).mkdirs(); // create downloads folder if not exists

        //  Set Chrome preferences to change default download path
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir);
        prefs.put("profile.default_content_settings.popups", 0);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open the URL and click the first download link
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector(".example a")).click();

        //  Pause briefly to allow file to download
        Thread.sleep(3000);

        //  Check if file is downloaded
        File folder = new File(downloadDir);
        File[] files = folder.listFiles();

        boolean fileDownloaded = false;
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().endsWith(".txt") || file.getName().endsWith(".jpg")) {
                    fileDownloaded = true;
                    System.out.println("Downloaded File: " + file.getName());
                    break;
                }
            }
        }

  

        // Cleanup (optional)
        driver.quit();
    }
}

