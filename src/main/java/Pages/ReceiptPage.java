package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class ReceiptPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public ReceiptPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement skipBtn;
    private WebElement doneBtn;
    private WebElement msgAfterTransaction;

    public void receipt_after_recharge_process() {

        skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']"));
        click_on_element(skipBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Receipt']"));
//    saveBtn = driver.findElement(By.id("btn_save"));
//    click_on_element(saveBtn);
    }

    public void receipt_after_bill_payment_process() {

        skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']"));
        click_on_element(skipBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Receipt']"));
        wait_for_element_with_locator_to_be_clickable(this.driver,
                By.xpath("//android.widget.Button[@text='Done']"));
//        wait_for_element_with_locator_to_be_visible(this.driver,
//                By.xpath("//android.widget.TextView[@text='Successful Transaction']"));


//    saveBtn = driver.findElement(By.id("btn_save"));
//    click_on_element(saveBtn)
    }

    public String get_transaction_message() {
        wait_for_element_with_locator_to_be_visible(this.driver,
                (By.id("payment_receipt_status")));
        msgAfterTransaction = driver.findElement(By.id("payment_receipt_status"));
        if (msgAfterTransaction.getAttribute("text").contains("Successful Transaction")) {
            // System.out.println("Successful transaction");
            System.out.println(msgAfterTransaction.getAttribute("text"));

        } else if (!(msgAfterTransaction.getAttribute("text").contains("Successful Transaction"))) {
            //System.out.println("Unsuccessful transaction");
            System.out.println(msgAfterTransaction.getAttribute("text"));
        }
        return msgAfterTransaction.getAttribute("text");
    }

    public HomePage return_to_homepage() {
        wait_for_element_with_locator_to_be_clickable(this.driver,
                By.xpath("//android.widget.Button[@text='Done']"));
        doneBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Done']"));
        click_on_element(doneBtn);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Wallet Balance']"));
        return new HomePage(driver);
    }
}
