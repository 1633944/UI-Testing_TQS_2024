import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/carousel.feature", glue="steps")
public class RunCarouselTest extends AbstractTestNGCucumberTests{
	
}