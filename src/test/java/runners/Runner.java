package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // if we have multiple we use { " ", " "}
        glue = "steps",
        tags = "@Regression",
        dryRun = false, // if tru --> will check if there any steps without implementation and show u the report
        monochrome = false,
        plugin = {"html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json", //<--we give meaningful name for the folder to hold reports
                "pretty"
        }
)
public class Runner {

}
