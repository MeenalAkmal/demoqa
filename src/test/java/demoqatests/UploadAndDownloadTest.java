package demoqatests;

import demoqapages.UploadAndDownloadPage;
import demoqabasetest.basetest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadAndDownloadTest extends basetest {

    @Test
    public void testUploadAndDownload() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");

        UploadAndDownloadPage page = new UploadAndDownloadPage(driver);

        // 1. Test download button
        page.clickDownloadButton();
        System.out.println(" Download button clicked (check Downloads folder manually)");

        // 2. Test upload
        String filePath = "C:\\Users\\meena\\Downloads\\testupload.jpeg"; 
        page.uploadFile(filePath);
        Thread.sleep(2000); // Wait for UI update

        String uploadedPath = page.getUploadedFilePath();
        System.out.println(" Uploaded file path: " + uploadedPath);

        assertTrue(uploadedPath.contains("testupload.jpeg"), "Uploaded file name not found in path!");
    }
}
