package skeleton;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-report/all"})
public class RunCukesTest {

}