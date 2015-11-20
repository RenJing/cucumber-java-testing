package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
                webdriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown driver specified, only 'firefox', 'chrome', 'ie' are supported");
        }
    }
}

