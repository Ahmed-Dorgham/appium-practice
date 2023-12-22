package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class HomePage extends UtilitiesMethods {
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement myWalletIcon;
    private WebElement paymentSection;
    private WebElement lastTransaction;
    private WebElement lastTransactionAmount;
    private WebElement lastTransactionIcon;

    public MyWalletPage open_my_wallet_page() {

        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Wallet Balance']"));
        myWalletIcon = driver.findElement(By.xpath("//android.widget.TextView[@text='My Wallet']"));
        click_on_element(myWalletIcon);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='My wallet details']"));
        return new MyWalletPage(driver);
    }

    public PaymentPage open_payment_page() {

        paymentSection = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment']"));
        click_on_element(paymentSection);
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("//android.widget.TextView[@text='Service Payment']"));
        return new PaymentPage(driver);
    }

    public void get_last_transaction_from_homepage_history() {
        wait_for_element_with_locator_to_be_visible(this.driver,
                By.xpath("(//android.widget.TextView[contains(@resource-id,'list_item_upper_left_text_view')])[1]"));
        lastTransaction = driver.findElement(By.
                xpath("(//android.widget.TextView[contains(@resource-id,'list_item_upper_left_text_view')])[1]"));
        lastTransactionAmount = driver.findElement(By.
                xpath("(//android.widget.TextView[contains(@resource-id,'list_item_upper_right_text_view')])[1]"));
        lastTransactionIcon = driver.findElement(By.
                xpath("(//android.widget.ImageView[contains(@resource-id,'list_item_icon')])[1]"));
        System.out.print(lastTransaction.getAttribute("text"));
        System.out.print(" = "+lastTransactionAmount.getAttribute("text"));
        //System.out.println(lastTransaction.getAttribute("text"));

    }
}
