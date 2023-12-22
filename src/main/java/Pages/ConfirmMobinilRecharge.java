package Pages;
import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
public class ConfirmMobinilRecharge extends UtilitiesMethods {
    private AndroidDriver driver;

    public ConfirmMobinilRecharge(AndroidDriver driver) {
        this.driver = driver;
    }
    private WebElement confirmBtn;
    private WebElement pinField;
    private WebElement okBtn;

    public ReceiptPage confirm_recharge_process(String pin) {


        confirmBtn = driver.findElement(By.id("confirm_prepaid_fragment_ok_button"));
        click_on_element(confirmBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Enter M-PIN(6 digits)']"));
        pinField = driver.findElement(By.id("et_code"));
        clear_data_from_input_field(pinField);
        enter_text_to_input_field(pinField, pin);
        okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        click_on_element(okBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Skip']"));
        return new ReceiptPage(driver);
    }
}
