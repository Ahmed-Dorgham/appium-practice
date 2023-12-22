package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class MobinilBillPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public MobinilBillPage(AndroidDriver driver) {
        this.driver = driver;
    }
    private WebElement firstMobileNumberField;
    private WebElement secondMobileNumberField;
    private WebElement paymentMethodField;
    private WebElement myWalletOption;
    private WebElement continueBtn;
    public RechargeAmountsPage enter_valid_data_to_pay_bill(String mobinilNumber) {

        firstMobileNumberField = driver.findElement
                (By.xpath("(//android.widget.EditText[contains(@resource-id,'custom_edittext_input')])[1]"));
        click_on_element(firstMobileNumberField);
        enter_text_to_input_field(firstMobileNumberField, mobinilNumber);
        secondMobileNumberField = driver.findElement
                (By.xpath("(//android.widget.EditText[contains(@resource-id,'custom_edittext_input')])[2]"));
        click_on_element(secondMobileNumberField);
        enter_text_to_input_field(secondMobileNumberField, mobinilNumber);
        paymentMethodField = driver.findElement
                (By.xpath("//MwalletCustomTextInputLayout[@text='Payment method']"));
        click_on_element(paymentMethodField);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='My Wallet']"));
        wait_for_element_with_locator_to_be_clickable(this.driver,
                By.xpath("//android.widget.TextView[@text='My Wallet']"));
        myWalletOption = driver.findElement(By.xpath("//android.widget.TextView[@text='My Wallet']"));
        click_on_element(myWalletOption);
        wait_for_element_with_locator_to_be_clickable(this.driver,
                By.xpath("//android.widget.Button[@text='Continue']"));
        continueBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
        click_on_element(continueBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Select Amount']"));
        return new RechargeAmountsPage(driver);
    }
}
