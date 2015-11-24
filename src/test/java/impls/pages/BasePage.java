package impls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final String HOST = "http://data.10086.cn/pc/";
    public static final int TIME_OUT_IN_SECONDS = 10;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertURL() {
        (new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS)).until(ExpectedConditions.urlContains(this.getAction()));
    }

    public String getURL() {
        return HOST + getAction();
    }

    protected WebElement waitForElementVisible(By findBy) {
        return (new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    abstract protected String getAction();
}
