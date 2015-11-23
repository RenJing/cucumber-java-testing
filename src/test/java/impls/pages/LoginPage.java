package impls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static final String URL = "http://data.10086.cn/pc/login.do";
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterMobileNumber(String mobileNumber) {
        WebElement mobileInput = webDriver.findElement(By.id("mobile"));
        mobileInput.sendKeys(mobileNumber);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    public String getLoginErrorMessage() {
        WebElement element = (new WebDriverWait(webDriver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.id("alertDiv")));
        return element.getText();
    }
}
