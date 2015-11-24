package impls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendRedEnvelope extends BasePage {
    public static final String URL = "redbag/red-package.do";

    public SendRedEnvelope(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected java.lang.String getAction() {
        return URL;
    }

    public void typePerson(String num) {
        webDriver.findElement(By.cssSelector("#ordinaryRed")).sendKeys(num);
    }

    public void typeRedEnvelope(String data) {
        webDriver.findElement(By.cssSelector("#aRedFlow")).sendKeys(data);
    }

    public void typeVerificationCode(String code) {
        webDriver.findElement(By.cssSelector("#averify")).sendKeys(code);
    }

    public void typeMessage(String msg) {
        webDriver.findElement(By.cssSelector("#coment")).sendKeys(msg);
    }

    public void clickRedOut() {
        webDriver.findElement(By.cssSelector("#redOut")).click();
    }
}
