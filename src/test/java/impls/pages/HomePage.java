package impls.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public static final String ACTION = "index.do";

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getAction() {
        return ACTION;
    }
}
