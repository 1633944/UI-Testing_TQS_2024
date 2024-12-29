import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/clothes.feature", glue="steps")
public class RunClothesTest extends AbstractTestNGCucumberTests{
	
}