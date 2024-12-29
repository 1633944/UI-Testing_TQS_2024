package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClothesSteps {

    WebDriver driver;

    @Given("the user is on the index page for clothes")
    public void theUserIsOnTheIndexPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        Thread.sleep(10000);
        driver.switchTo().frame("framelive");
    }

    @When("the user clicks on {string}")
    public void theUserClicksOn(String menuOption) throws InterruptedException {
        Thread.sleep(5000); // Esperar a que los elementos estén visibles
        WebElement clothesLink = driver.findElement(By.id("category-3"));
        clothesLink.click();
    }

    @When("the user choose the {string} category")
    public void theUserChooseTheCategory(String category) throws InterruptedException {
        Thread.sleep(3000); // Esperar a que los elementos estén visibles
        WebElement categoryLink = driver.findElement(By.linkText(category));
        categoryLink.click();
    }

    @Then("the user is redirected to the {string} page")
    public void theUserIsRedirectedToThePage(String category) throws InterruptedException {
        Thread.sleep(3000); // Esperar a que la página cargue
        WebElement categoryLink = driver.findElement(By.className("block-categories"));
        String headerText = categoryLink.getText();
        Assert.assertEquals(headerText, category, "The page header does not match the selected category.");
        driver.quit();
    }
}
