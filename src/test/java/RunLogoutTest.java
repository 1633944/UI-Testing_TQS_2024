import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/logout.feature", glue="steps")
public class RunLogoutTest extends AbstractTestNGCucumberTests{
	
}