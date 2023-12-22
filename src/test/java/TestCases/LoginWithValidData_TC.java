package TestCases;

import Pages.LoginPage;
import Pages.ServerPage;
import Pages.SkipPage;
import TestBase.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithValidData_TC extends TestBase {

    String mobileNumber = "01091650155";
    String pin = "147258";
    String activationCode = "14258";

    private ServerPage serverPageObject;
    private SkipPage skipPageObject;
    private LoginPage loginPageObject;

    @Test (priority = 1)
    private void enter_data_into_server_page() throws IOException {
        serverPageObject = new ServerPage(driver);
        serverPageObject.enter_data_into_server_page();
        skipPageObject = serverPageObject.click_on_allow_notification_btn();

    }
    @Test (priority = 2)
    private void enter_valid_data_into_login_page() throws IOException {

        loginPageObject = skipPageObject.click_on_skip_btn();
        loginPageObject.click_on_accept_terms_and_conditions_checkbox();
        loginPageObject.enter_valid_data(mobileNumber, pin);
        loginPageObject.click_on_login_btn();
        loginPageObject.enter_activation_code(activationCode);

    }
}
