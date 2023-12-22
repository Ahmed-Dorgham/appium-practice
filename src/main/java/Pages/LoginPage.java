package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class LoginPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement acceptTermsCheckbox;
    private WebElement okBtn;
    private WebElement mobileNumnberField;
    private WebElement pinField;
    private WebElement loginBtn;
    private WebElement acivationCodeField;

    public void click_on_accept_terms_and_conditions_checkbox() {
       // wait_for_element_with_locator_to_be_visible(this.driver, By.id("ch_agree"));
        acceptTermsCheckbox = driver.findElement(By.id("ch_agree"));
        click_on_element(acceptTermsCheckbox);
        //okBtn = driver.findElement(By.id("btn_positive"));
        okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        click_on_element(okBtn);

    }

    public void enter_valid_data(String mobileNumber, String pin) {
        wait_for_element_with_locator_to_be_visible(this.driver, By.id("text_input_layout_username"));
        mobileNumnberField = driver.findElement(By.id("editText_username"));
        click_on_element(mobileNumnberField);
        clear_data_from_input_field(mobileNumnberField);
        enter_text_to_input_field(mobileNumnberField, mobileNumber);
        pinField = driver.findElement(By.id("editText_password"));
        click_on_element(pinField);
        clear_data_from_input_field(pinField);
        enter_text_to_input_field(pinField, pin);

    }

    public void click_on_login_btn() {
        wait_for_element_with_locator_to_be_clickable(this.driver, By.id("button_login"));
        loginBtn = driver.findElement(By.id("button_login"));
        click_on_element(loginBtn);
    }

    public HomePage enter_activation_code(String activationCode) {
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Activation code']"));

        acivationCodeField = driver.findElement(By.id("et_code"));
        clear_data_from_input_field(acivationCodeField);
        enter_text_to_input_field(acivationCodeField, activationCode);
        //okBtn = driver.findElement(By.id("button_confirm"));
        okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        click_on_element(okBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Your activation code has been submitted successfully']"));
        // okBtn = driver.findElement(By.id("custom_dialog_okBtn_id"));
        okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        click_on_element(okBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Wallet Balance']"));
        return new HomePage(driver);
    }
}
