import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/contact.feature", glue="steps")
public class RunContactTest extends AbstractTestNGCucumberTests{
	
}