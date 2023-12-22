package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
public class SkipPage extends UtilitiesMethods {
    private AndroidDriver driver;
    public SkipPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement skipBtn;
    public LoginPage click_on_skip_btn() {

        skipBtn = driver.findElement(By.id("skip_button"));
        click_on_element(skipBtn);
        wait_for_element_with_locator_to_be_visible(this.driver, By.id("ch_agree"));
        return new LoginPage(driver);
    }
}
