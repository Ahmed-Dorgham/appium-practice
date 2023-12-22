package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;


public class PaymentPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement telecomAndInternetOption;

    public TelecomAndInternetPage click_on_telecom_and_internet_option() {
        telecomAndInternetOption = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Telecom & internet']"));
        click_on_element(telecomAndInternetOption);

        return new TelecomAndInternetPage(driver);
    }

}
