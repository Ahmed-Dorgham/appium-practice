package TestCases;

import Pages.*;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VodafoneBill_TC extends TestBase {
    String mobileNumber = "01091650155";
    String pin = "147258";
    String activationCode = "14258";
    String vodafoneNumber = "01200000200";

    private ServerPage serverPageObject;
    private SkipPage skipPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private PaymentPage paymentPageObject;
    private TelecomAndInternetPage telecomAndInternetPageObject;
    private VodafoneOptionsPage vodafoneOptionsPageObject;
    private VodafoneBillPage vodafoneBillPageObject;
    private ConfirmVodafoneBill confirmVodafoneBillObject;
    private ReceiptPage receiptPageObject;

    @Test(priority = 1)
    private void login_with_valid_data() throws IOException {
        serverPageObject = new ServerPage(driver);
        serverPageObject.enter_data_into_server_page();
        skipPageObject = serverPageObject.click_on_allow_notification_btn();
        loginPageObject = skipPageObject.click_on_skip_btn();
        loginPageObject.click_on_accept_terms_and_conditions_checkbox();
        loginPageObject.enter_valid_data(mobileNumber, pin);
        loginPageObject.click_on_login_btn();
        homePageObject = loginPageObject.enter_activation_code(activationCode);
    }

    @Test(priority = 2)
    private void pay_vodafone_bill() throws IOException {

        paymentPageObject = homePageObject.open_payment_page();
        telecomAndInternetPageObject = paymentPageObject.click_on_telecom_and_internet_option();
        vodafoneOptionsPageObject = telecomAndInternetPageObject.click_on_vodafone_option();
        vodafoneBillPageObject = vodafoneOptionsPageObject.click_on_vodafone_bill();
        confirmVodafoneBillObject = vodafoneBillPageObject.enter_valid_data_to_pay_bill(vodafoneNumber);
        receiptPageObject = confirmVodafoneBillObject.confirm_bill_payment_process(pin);
        receiptPageObject.receipt_after_bill_payment_process();
        //  receiptPageObject.get_transaction_message();
        Assert.assertTrue(receiptPageObject.get_transaction_message().contains("Successful Transaction"));
        homePageObject = receiptPageObject.return_to_homepage();
        homePageObject.get_last_transaction_from_homepage_history();

    }
}
