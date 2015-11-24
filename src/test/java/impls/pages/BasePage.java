package impls.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utls.TestProperty;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Set;

public abstract class BasePage {
    public static final String HOST = "http://data.10086.cn/pc/";
    public static final int TIME_OUT_IN_SECONDS = 15;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertURL() {
        (new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS)).until(ExpectedConditions.urlContains(this.getAction()));
    }

    public void go() {
        webDriver.get(getURL());
    }

    public String getURL() {
        return HOST + getAction();
    }

    protected WebElement waitForElementVisible(By findBy) {
        return (new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    protected void waitForAlertPresent() {
        (new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
    }

    abstract protected String getAction();

    protected void closeAllWindows() {
        Set<String> set = webDriver.getWindowHandles();

        int num = set.toArray().length;
        for (int i = 0; i < num; i++) {
            webDriver.switchTo().window((String) set.toArray()[i]);
            webDriver.close();
        }
//        webDriver.quit();
    }

    public void waitForAjax() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        long begin = System.currentTimeMillis();
        while (System.currentTimeMillis() - begin < Long.parseLong(TestProperty.getProperty("timeout"))) {
            boolean ajaxIsComplete = (boolean) js.executeScript("return jQuery.active==0");
            if (ajaxIsComplete)
                break;
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void waitElementDisplay(String loc) {
        long begin = System.currentTimeMillis();
        do {
            boolean bol = webDriver.findElement(By.cssSelector(loc)).isDisplayed();
            if (bol)
                break;
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while ((System.currentTimeMillis() - begin) < Long.parseLong(TestProperty.getProperty("timeout")));
    }

    /**
     * From index 0
     */
    protected String getSpecifiedLineContent(String fileName, int lineNumber) throws IOException {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "datacollection" + File.separator + fileName;
        File sourceFile = new File(filePath);

        String content = readAppointedLineNumber(sourceFile, lineNumber);
        return content;
    }

    private synchronized String readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = null;
        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("Line number is out of bound");
        }
        {
            while (reader.getLineNumber() < lineNumber + 1) {
                s = reader.readLine();
            }
        }
        reader.close();
        in.close();
        return s;
    }

    private int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
}
