package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"

        },
        features = "src/test/resources/feature",
        glue={"Steps","org/example/Test"}
)

public class TestRunners extends AbstractTestNGCucumberTests {
}
