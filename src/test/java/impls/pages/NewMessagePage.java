package impls.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by twe on 11/24/15.
 */
public class NewMessagePage extends BasePage {
    @Override
    protected String getAction() {
        return null;
    }

    public NewMessagePage(WebDriver webDriver){
        super(webDriver);
    }

    public String getAccountMessage() {
        return webDriver.findElement(By.cssSelector(".remind_tabl li div font")).getText();
    }

    public void checkAccountMessage(String data, String mobile) {
        Assert.assertTrue(getAccountMessage().contains(data) && getAccountMessage().contains(mobile));
    }

    public void checkNoWatchedMessageNum(String num) {
        String foundNum = webDriver.findElement(By.cssSelector(".remind_num span")).getText();
        Assert.assertTrue(foundNum.equalsIgnoreCase(num));
    }
}
