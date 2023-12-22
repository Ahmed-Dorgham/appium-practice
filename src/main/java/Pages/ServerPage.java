package Pages;

import UtilitiesMethods.UtilitiesMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import java.io.IOException;

public class ServerPage extends UtilitiesMethods {
    private AndroidDriver driver;

    public ServerPage(AndroidDriver driver) {
        this.driver = driver;
    }
    String filePath = "src/main/resources/serverdata.properties";
    String serverUrlValue;
    private WebElement serverListField;
    private WebElement serverType;
    private WebElement serverUrlField;
    private WebElement saveBtn;
    private WebElement allowBtn;
    public void enter_data_into_server_page() throws IOException {

        serverListField = driver.findElement(By.id("spinner_url_name"));
        click_on_element(serverListField);
        wait_for_element_with_locator_to_be_visible
                (this.driver, By.xpath("//android.widget.CheckedTextView[@text='Custom']"));
        serverType = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Custom']"));
        wait_for_element_to_be_clickable(this.driver, serverType);
        click_on_element(serverType);
        serverUrlField = driver.findElement(By.id("et_url_value"));
        clear_data_from_input_field(serverUrlField);
        serverUrlValue = read_data_from_properties_file(filePath, "urlValue");
        enter_text_to_input_field(serverUrlField, serverUrlValue);
        wait_for_text_to_be_present_in_element(this.driver, serverUrlField, serverUrlValue);
        wait_for_element_with_locator_to_be_clickable(this.driver, By.id("btn_save"));
        saveBtn = driver.findElement(By.id("btn_save"));
        click_on_element(saveBtn);

    }
    public SkipPage click_on_allow_notification_btn() {
        wait_for_element_with_locator_to_be_present(this.driver,
                By.xpath("//android.widget.Button[@text='Allow']"));
        allowBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Allow']"));
        click_on_element(allowBtn);
        wait_for_element_with_locator_to_be_clickable(this.driver, By.id("skip_button"));
        return new SkipPage(driver);
    }
}
