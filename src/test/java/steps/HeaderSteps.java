package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderSteps {

    WebDriver driver;

    @Given("the user is on the index page for header")
    public void theUserIsOnTheIndexPage() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
    }

    @When("the user checks the header")
    public void theUserChecksTheHeader() throws InterruptedException {
    	Thread.sleep(10000);
        WebElement header = driver.findElement(By.tagName("header"));
        Assert.assertTrue(header.isDisplayed(), "El header no está visible.");
    }

    @Then("the user verifies the logo is visible and clickable")
    public void theUserVerifiesTheLogoIsVisibleAndClickable() {
        WebElement logo = driver.findElement(By.xpath("//header//img[@alt='PrestaShop']"));
        
        // Verificar si el logotipo es visible
        Assert.assertTrue(logo.isDisplayed(), "El logotipo no está visible en el header.");
        
        // Verificar si el logotipo es clicable
        Assert.assertTrue(logo.isEnabled(), "El logotipo no está habilitado para ser clicado.");

        driver.quit();
    }
}
