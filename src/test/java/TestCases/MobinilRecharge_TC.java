package TestCases;
import Pages.*;
import TestBase.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class MobinilRecharge_TC extends TestBase {
    String mobileNumber = "01091650155";
    String pin = "147258";
    String activationCode = "14258";
    String mobinilNumber = "01200000200";
    String rechargeAmount = "10";

    private ServerPage serverPageObject;
    private SkipPage skipPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private PaymentPage paymentPageObject;
    private TelecomAndInternetPage telecomAndInternetPageObject;
    private MobinilOptionsPage mobinilOptionsPageObject;
    private MobinilRechargePage mobinilRechargePageObject;
    private RechargeAmountsPage amountsPageObject;
    private ConfirmMobinilRecharge confirmMobinilRechargeObject;
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
    private void recharge_mobinil_number() throws IOException {

        paymentPageObject = homePageObject.open_payment_page();
        telecomAndInternetPageObject = paymentPageObject.click_on_telecom_and_internet_option();
        mobinilOptionsPageObject = telecomAndInternetPageObject.click_on_mobinil_option();
        mobinilRechargePageObject = mobinilOptionsPageObject.click_on_mobinil_recharge();
        amountsPageObject = mobinilRechargePageObject.enter_valid_data_to_recharge(mobinilNumber);
        confirmMobinilRechargeObject = amountsPageObject.enter_specific_amount(rechargeAmount);
        receiptPageObject = confirmMobinilRechargeObject.confirm_recharge_process(pin);
        receiptPageObject.receipt_after_recharge_process();
    }
}
