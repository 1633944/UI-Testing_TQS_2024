package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TShirtSteps {
	
	WebDriver driver;
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://demo.prestashop.com/");
	    System.out.println("Frames disponibles: " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("framelive");
	}
	
    @When("^the user enters (.*) in the search bar")
    public void theUserEntersInTheSearchBar(String article) throws InterruptedException {
    	Thread.sleep(10000);
    	WebElement searchBar = driver.findElement(By.name("s"));
        searchBar.clear();
        searchBar.sendKeys(article);
    }
	
    @When("the user press the Enter key")
    public void theUserPressTheEnterKey() {
        WebElement searchBar = driver.findElement(By.name("s"));
        searchBar.sendKeys(Keys.RETURN); // Simula presionar la tecla "Enter"
    }
	
    @Then("^the (.*) list appears")
    public void theListAppears(String article) throws InterruptedException{
    	Thread.sleep(1000);

        // Obtener el título de los resultados de búsqueda
        String title = driver.findElement(By.id("js-product-list-header")).getText();
        
        // Verificar que el título contiene "Search results"
        Assert.assertTrue(title.contains("SEARCH RESULTS"));
    }
}
