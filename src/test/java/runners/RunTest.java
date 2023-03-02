package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features/LoginFeature.feature" ,
        glue = {"pages.stepDefinitions"}

)

public class RunTest extends AbstractTestNGCucumberTests {
}
