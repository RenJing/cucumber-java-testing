package impls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String URL = "login.do";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterMobileNumber(String mobileNumber) {
        webDriver.findElement(By.id("mobile")).sendKeys(mobileNumber);
    }

    public void enterPassword(String password) {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(By.id("loginButton")).click();
    }

    public String getLoginErrorMessage() {
        return waitForElementVisible(By.id("alertDiv")).getText();
    }

    public void enterCaptcha(String captcha) {
        webDriver.findElement(By.id("checkCode")).sendKeys(captcha);
    }

    @Override
    protected String getAction() {
        return URL;
    }

    public void login(String mobile, String password) {
        enterMobileNumber(mobile);
        enterPassword(password);
        clickLoginButton();
    }
}
