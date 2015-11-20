package skeleton;

import config.WebDriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Stepdefs {
    private WebDriver webDriver;
    private String url;

    public Stepdefs() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.url = "http://www.baidu.com";
    }

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
        webDriver.get(url);
        webDriver.findElement(By.id("test"));
    }
    
    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
