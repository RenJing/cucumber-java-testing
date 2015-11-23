package impls.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    private WebDriver webDriver;
    private String url;

    public LoginSteps() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.url = "http://data.10086.cn/pc/login.do";
    }

    @Given("^I am on login page$")
    public void i_am_on_login_page() throws Throwable {
        webDriver.get(url);
    }

    @When("^I enter phone number \"(.*?)\" and password \"(.*?)\"$")
    public void i_enter_phone_number_and_password(String mobileNumber, String password) throws Throwable {
        WebElement mobileInput = webDriver.findElement(By.id("mobile"));
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        mobileInput.sendKeys(mobileNumber);
        passwordInput.sendKeys(password);
    }

    @When("^I click login button$")
    public void i_click_login_button() throws Throwable {
    	WebElement loginButton = webDriver.findElement(By.id("loginButton"));
    	loginButton.click();
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void i_should_see_error_message(String expectedErrorMessage) {
        WebElement element = (new WebDriverWait(webDriver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.id("alertDiv")));
        String errorMessage = element.getText();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }
}