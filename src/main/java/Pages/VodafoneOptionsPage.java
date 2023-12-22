package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
public class VodafoneOptionsPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public VodafoneOptionsPage(AndroidDriver driver) {
        this.driver = driver;
    }
    private WebElement vodafoneRechargeOption;
    private WebElement vodafoneBillOption;
    public MobinilRechargePage click_on_vodafone_recharge ()
    {

        vodafoneRechargeOption = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Mobinil Recharge']"));
        click_on_element(vodafoneRechargeOption);
        return new MobinilRechargePage(driver);
    }
    public VodafoneBillPage click_on_vodafone_bill ()
    {
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Vodafone bill']"));
        vodafoneBillOption = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Vodafone bill']"));
        click_on_element(vodafoneBillOption);
        return new VodafoneBillPage(driver);
    }
}
