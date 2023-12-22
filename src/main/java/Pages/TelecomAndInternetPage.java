package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
public class TelecomAndInternetPage extends UtilitiesMethods {

    private AndroidDriver driver;

    public TelecomAndInternetPage(AndroidDriver driver) {
        this.driver = driver;
    }
    private WebElement mobinilProvider;
    private WebElement vodafoneProvider;
    public MobinilOptionsPage click_on_mobinil_option ()
    {

        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Select Service Provider']"));
        mobinilProvider = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Mobinil']"));
        click_on_element(mobinilProvider);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Mobinil Recharge']"));
        return new MobinilOptionsPage (driver);
    }
    public VodafoneOptionsPage click_on_vodafone_option ()
    {
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Select Service Provider']"));
        vodafoneProvider = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Vodafone']"));
        click_on_element(vodafoneProvider);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Mobinil Recharge']"));
        return new VodafoneOptionsPage (driver);
    }
}
