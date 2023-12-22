package TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public AndroidDriver driver;

    @Parameters({"platformName", "deviceName"})
    @BeforeTest
    public void setup(@Optional("Android") String platformName, @Optional("Pixel 7") String deviceName) throws IOException, InterruptedException {

        if (platformName.equalsIgnoreCase("Android")) {

            File file = new File("src/main/resources/config.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fileInputStream);
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("platformName", platformName);
            dc.setCapability("deviceName", deviceName);
            //  dc.setCapability("browserName", "chrome");
            dc.setCapability("appPackage", prop.getProperty("appPackage"));
            dc.setCapability("appActivity", prop.getProperty("appActivity"));
            WebDriverManager.chromedriver().setup();
            dc.setCapability("chromedriverExecutableDir", WebDriverManager.chromedriver().getDownloadedDriverPath());
            driver = new AndroidDriver(new URL(prop.getProperty("appiumServerURL")), dc);
        } else {
            System.out.println("platform is IOS and this is not handeled yet !!!!!!!!!!!1");
        }

    }

   // @AfterTest
    public void close_app() {
        // driver.lockDevice();
        driver.quit();

    }
}
