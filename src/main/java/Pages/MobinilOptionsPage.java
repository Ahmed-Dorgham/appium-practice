package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class MobinilOptionsPage extends UtilitiesMethods {
    private AndroidDriver driver;
    public MobinilOptionsPage(AndroidDriver driver) {
        this.driver = driver;
    }
    private WebElement mobinilRechargeOption;
    private WebElement mobinilBillOption;
    public MobinilRechargePage click_on_mobinil_recharge ()
    {

        mobinilRechargeOption = driver.findElement
                (By.xpath("//android.widget.TextView[@text='Mobinil Recharge']"));
        click_on_element(mobinilRechargeOption);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("(//android.widget.EditText[contains(@resource-id,'custom_edittext_input')])[1]"));
        return new MobinilRechargePage(driver);
    }

    public MobinilBillPage click_on_mobinil_bill ()
    {
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Mobinil Bill']"));
        mobinilBillOption = driver.findElement
                (By.xpath("//android.widget.TextView[@text=Mobinil Bill']"));
        click_on_element(mobinilBillOption);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("(//android.widget.EditText[contains(@resource-id,'custom_edittext_input')])[1]"));
        return new MobinilBillPage(driver);
    }
}
