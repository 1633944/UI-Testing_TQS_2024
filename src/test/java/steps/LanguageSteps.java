package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageSteps {
    
    WebDriver driver;

    @Given("the user is on the index page")
    public void theUserIsOnTheIndexPage() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
    }

    @When("the user opens the language selection dropdown")
    public void theUserOpensTheLanguageSelectionDropdown() throws InterruptedException {
    	Thread.sleep(10000);
    	driver.findElement(By.className("expand-more")).click();
    }

    @When("^the user selects (.*)")
    public void theUserSelects(String language) throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement selectedLanguage = driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(text(),'" + language + "')]"));
        selectedLanguage.click();
        Thread.sleep(3000);
    }

    @Then("^the site is displayed in (.*)")
    public void theSiteIsDisplayedIn(String language) throws InterruptedException {
        // Esperar un poco para asegurarnos de que el cambio de idioma se haya completado
        Thread.sleep(2000);

        // Obtener el idioma actual seleccionado en el dropdown
        WebElement activeLanguageElement = driver.findElement(By.className("expand-more"));
        String activeLanguage = activeLanguageElement.getText().trim();

        // Comprobar si el idioma seleccionado coincide con el esperado
        Assert.assertEquals(activeLanguage, language, "El idioma mostrado no coincide con el seleccionado.");
    }
}