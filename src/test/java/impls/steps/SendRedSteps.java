package impls.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helper.WebDriverFactory;
import impls.pages.SendRedEnvelope;
import org.openqa.selenium.WebDriver;


public class SendRedSteps {
    private final SendRedEnvelope sendRedPage;
    private WebDriver webDriver;

    public SendRedSteps() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.sendRedPage = new SendRedEnvelope(webDriver);
    }

    @Given("^我在派发红包页面$")
    public void i_am_on_give_flow_page() {
        sendRedPage.go();
    }

    @When("^我要发\"(.*?)\"个人的红包$")
    public void i_type_person_num(String num) throws Throwable {
        sendRedPage.typePerson(num);
    }

    @When("^我要发的红包有\"(.*?)\"M流量")
    public void i_type_num_in_red(String num) {
        sendRedPage.typeRedEnvelope(num);
    }

    @When("^我要出入的短信验证码是\"(.*?)\"$")
    public void i_type_verification_code(String code) {
        sendRedPage.typeVerificationCode(code);
    }

    @When("^我要给TA留言的内容是:\"(.*?)\"$")
    public void i_type_msg(String msg) {
        sendRedPage.typeMessage(msg);
    }

    @When("^点击我要发红包$")
    public void i_click_send_red() {
        sendRedPage.clickRedOut();
    }
}
