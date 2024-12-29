import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/footer.feature", glue="steps")
public class RunFooterTest extends AbstractTestNGCucumberTests {
}