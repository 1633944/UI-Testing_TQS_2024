import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/language.feature", glue="steps")
public class RunLanguageTest extends AbstractTestNGCucumberTests {
}