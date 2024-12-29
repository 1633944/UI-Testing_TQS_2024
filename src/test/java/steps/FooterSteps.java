package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterSteps {
    
    WebDriver driver;

    @Given("the user is on the index page for footer")
    public void theUserIsOnTheIndexPage() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
    }

    @When("the user scrolls to the footer")
    public void theUserScrollsToTheFooter() throws InterruptedException {
        boolean footerFound = false;

        for (int i = 0; i < 5; i++) { // Reintenta hasta 5 veces
            try {
                Thread.sleep(3000);
                WebElement footer = driver.findElement(By.tagName("footer"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
                footerFound = true;
                break; // Sal del bucle si se encuentra el footer
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Footer not found. Retrying...");
            }
        }

        if (!footerFound) {
            Assert.fail("Footer element could not be located after multiple retries.");
        }
    }

    @SuppressWarnings("deprecation")
	@Then("the user verifies that all footer links are clickable")
    public void theUserVerifiesThatAllFooterLinksAreClickable() {
        // Encuentra todos los enlaces visibles en el footer
        List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));

        // Verifica que los enlaces sean visibles y habilitados
        for (WebElement link : footerLinks) {
            if (link.isDisplayed()) { // Solo verificamos enlaces visibles
                Assert.assertTrue(link.isEnabled(), "El enlace no está habilitado: " + link.getText());
            } else {
                System.out.println("Enlace no visible: " + link.getAttribute("href"));
            }
        }

        driver.quit();
    }
}
