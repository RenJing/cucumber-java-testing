package impls;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepDefsHooks {
    @Before
    public void setup() {
        WebDriverFactory.getWebDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        String browser = System.getProperty("browser", "firefox");
        scenario.write("%%%%%%%%%%%%%");
        scenario.write("%%%%%%%%%%%%%");
        scenario.write("%%%%%%%%%%%%%");
        scenario.write("%%%%%%%%%%%%%");
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        WebDriverFactory.getWebDriver().close();
    }
}
