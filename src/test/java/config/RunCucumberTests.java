package config;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"stepdefs"},
        tags = {"@dev"}) //add a tag such as @dev to run one test at a time and add the same tag above the Scenario: line for the test you want to run
public class RunCucumberTests {
}