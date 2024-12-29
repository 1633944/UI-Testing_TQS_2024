import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/art.feature", glue="steps")
public class RunArtTest extends AbstractTestNGCucumberTests{
	
}