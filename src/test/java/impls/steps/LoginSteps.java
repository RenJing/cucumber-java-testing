package impls.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.WebDriverFactory;
import impls.pages.HomePage;
import impls.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final LoginPage loginPage;
    private WebDriver webDriver;

    public LoginSteps() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.loginPage = new LoginPage(webDriver);
    }

    @Given("^I am on login page$")
    public void i_am_on_login_page() {
        webDriver.get(loginPage.getURL());
    }

    @When("^I enter phone number \"(.*?)\" and password \"(.*?)\"$")
    public void i_enter_phone_number_and_password(String mobileNumber, String password) throws Throwable {
        loginPage.enterMobileNumber(mobileNumber);
        loginPage.enterPassword(password);
    }

    @When("^I click login button$")
    public void i_click_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void i_should_see_error_message(String expectedErrorMessage) {
        String errorMessage = loginPage.getLoginErrorMessage();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @And("^I enter captcha \"([^\"]*)\"$")
    public void I_enter_captcha(String captcha) {
        loginPage.enterCaptcha(captcha);
    }

    @Then("^I should on home page$")
    public void i_should_on_home_page() {
        new HomePage(webDriver).assertURL();
    }
}