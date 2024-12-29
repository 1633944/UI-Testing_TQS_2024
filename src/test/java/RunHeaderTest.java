import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/header.feature", glue="steps")
public class RunHeaderTest extends AbstractTestNGCucumberTests {
}