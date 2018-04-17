package step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/himrekha/IdeaProjects/CPQFlintFramework/src/main/resources/SignIn.feature",
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
        tags = {}
)
public class RunCukesTest {
}
