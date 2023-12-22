package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ServerPage;
import Pages.SkipPage;
import TestBase.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnloadDSA_TC extends TestBase {
    String mobileNumber = "01091650155";
    String pin = "147258";
    String activationCode = "14258";

    private ServerPage serverPageObject;
    private SkipPage skipPageObject;
    private LoginPage loginPageObject;
    private HomePage homePageObject;

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
    private void Unload_DSA() throws IOException {

        homePageObject.open_my_wallet_page();

    }
}

