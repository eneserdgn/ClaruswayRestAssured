package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        tags = "@ENDTOEND",
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions", "utils"},
        plugin = {
                "summary",
                "pretty"
        }
)
public class testRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
