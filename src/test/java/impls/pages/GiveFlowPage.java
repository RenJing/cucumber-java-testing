package impls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiveFlowPage extends BasePage {
    public static final String URL = "give/give-flow.do";

    public GiveFlowPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getAction() {
        return URL;
    }

    public void addNewFriend(String mobile, String name) {
        WebElement addFriendButton = webDriver.findElement(By.id("newAdd"));
        addFriendButton.click();
        waitForElementVisible(By.id("textfield1"));
        webDriver.findElement(By.id("textfield1")).sendKeys(name);
        webDriver.findElement(By.id("textfield2")).sendKeys(mobile);
        webDriver.findElement(By.id("addSubmit")).click();
        waitForAlertPresent();
        webDriver.switchTo().alert().accept();
    }

    public void selectFlowSize(String number) {
        WebElement flowSizeRadio = webDriver.findElement(By.cssSelector(String.format("input[name='flowSize'][value='%s']", number)));
        flowSizeRadio.click();
    }
}
