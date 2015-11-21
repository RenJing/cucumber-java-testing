package helper;

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
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\twer\\Desktop\\chromedriver_win32\\chromedriver.exe");
                webdriver = new ChromeDriver();
                break;
            case("ie"):
            	System.setProperty("webdriver.ie.driver", "C:\\Users\\twer\\Desktop\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
                webdriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown driver specified, only 'firefox', 'chrome', 'ie' are supported");
        }
    }
}

