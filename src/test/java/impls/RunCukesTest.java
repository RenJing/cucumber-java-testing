package impls;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/completed"},
        glue = {"impls"},
        plugin = {"html:target/cucumber-report/all"},
        tags = {"~@ignore"}
)
public class RunCukesTest {

}