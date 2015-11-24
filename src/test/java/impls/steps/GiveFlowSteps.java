package impls.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.WebDriverFactory;
import impls.pages.GiveFlowPage;
import impls.pages.HomePage;
import impls.pages.LoginPage;
import org.junit.Assert;
import org.omg.CORBA.portable.ApplicationException;
import org.openqa.selenium.WebDriver;

public class GiveFlowSteps {
    private final LoginPage loginPage;
    private final GiveFlowPage giveFlowPage;
    private WebDriver webDriver;

    public GiveFlowSteps() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.loginPage = new LoginPage(webDriver);
        this.giveFlowPage = new GiveFlowPage(webDriver);
    }

    @Given("^I logged in with a new user$")
    public void i_logged_in_with_a_new_user() {
        loginPage.go();
        loginPage.login("13811250299", "renjing123");
        new HomePage(webDriver).assertURL();
    }

    @Given("^I am on give flow page$")
    public void i_am_on_give_flow_page() {
        giveFlowPage.go();
    }

    @When("^I add new friend with mobile \"([^\"]*)\" and name \"([^\"]*)\"$")
    public void i_add_new_friend_with_mobile_and_name(String mobile, String name) {
        giveFlowPage.addNewFriend(mobile, name);
    }

    @When("^I select flow size \"([^\"]*)\"M$")
    public void i_select_flow_size_M(String number) {
        giveFlowPage.selectFlowSize(number);
    }

    @When("^I click give button$")
    public void i_click_give_button() {
        giveFlowPage.clickGiveButton();
    }

    @When("^I click confirm button$")
    public void i_click_confirm_button() {
    }

    @Then("^I should see succeed message$")
    public void i_should_see_succeed_message() {
    }

    @When("^I select friend with name \"([^\"]*)\"$")
    public void i_select_friend_with_name(String name) {
        giveFlowPage.chooseFriend(name);
    }

    @Given("^I should see flow not enough error message$")
    public void i_should_see_flow_not_enough_error_message() {
        String errorMessage = giveFlowPage.getSubmitErrorMessage();
        Assert.assertEquals("xxxx", errorMessage);
    }
}