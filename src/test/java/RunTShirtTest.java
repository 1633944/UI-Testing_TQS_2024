import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/tshirt.feature", glue="steps")
public class RunTShirtTest extends AbstractTestNGCucumberTests{
	
}