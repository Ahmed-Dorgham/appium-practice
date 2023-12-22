package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;


public class RechargeAmountsPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public RechargeAmountsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement anotherAmountField;
    private WebElement amountField;
    private WebElement okBtn;

    public ConfirmMobinilRecharge enter_specific_amount(String amount) {

        anotherAmountField = driver.findElement
                (By.xpath("(//android.widget.TextView[contains(@resource-id,'list_item_upper_left_text_view')])[1]"));
        click_on_element(anotherAmountField);
        wait_for_element_with_locator_to_be_present(this.driver,
                By.id("com.Fawry.ADCB.test:id/custom_edittext_input"));
        amountField = driver.findElement(By.id("com.Fawry.ADCB.test:id/custom_edittext_input"));
        click_on_element(amountField);
        clear_data_from_input_field(amountField);
        enter_text_to_input_field(amountField, amount);
        okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        click_on_element(okBtn);
        wait_for_element_with_locator_to_be_clickable(this.driver, By.id("confirm_prepaid_fragment_ok_button"));
        return new ConfirmMobinilRecharge(driver);
    }
}
