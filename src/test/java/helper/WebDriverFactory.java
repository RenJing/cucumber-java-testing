package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static WebDriver webdriver;

    private static final String defaultBrowser = "firefox";

    public static WebDriver getWebDriver() {
        if (null == webdriver) {
            instantiateWebDriver();
        }
        return webdriver;
    }

    public static void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
        }
    }

    private static void instantiateWebDriver() {
        String browser = System.getProperty("browser", defaultBrowser).toLowerCase();
        switch (browser) {
            case("firefox"):
                webdriver = new FirefoxDriver();
                break;
            case("chrome"):
                System.setProperty("webdriver.chrome.driver", "/Users/twer/Downloads/chromedriver");
                webdriver = new ChromeDriver();
                break;
            case("ie"):
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
                capabilities.setCapability("requireWindowFocus", true);
                webdriver = new InternetExplorerDriver(capabilities);
                break;
            default:
                throw new IllegalArgumentException("Unknown driver specified, only 'firefox', 'chrome', 'ie' are supported");
        }
    }
}

