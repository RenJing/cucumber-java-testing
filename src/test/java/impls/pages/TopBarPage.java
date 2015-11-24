package impls.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utls.TestProperty;

/**
 * Created by twe on 11/24/15.
 */
public class TopBarPage extends BasePage {

    @Override
    protected String getAction() {
        return null;
    }

    public TopBarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickNewMessage() {
        webDriver.findElement(By.cssSelector(TestProperty.getProperty("top.bar.msg.num"))).click();
    }

}
