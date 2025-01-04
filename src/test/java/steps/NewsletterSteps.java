package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewsletterSteps {

    WebDriver driver;

    @Given("the user is on the homepage for newsletter")
    public void theUserIsOnTheHomepageForNewsletter() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        Thread.sleep(10000); // Esperar a que el iframe cargue completamente
        driver.switchTo().frame("framelive");
    }

    @When("the user enters {string} into the subscription field")
    public void theUserEntersIntoTheSubscriptionField(String email) throws InterruptedException {
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(email);
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonText) throws InterruptedException {
        Thread.sleep(1000);
        WebElement subscribeButton = driver.findElement(By.xpath("//input[@value='Subscribe']"));
        subscribeButton.click();
    }

    @Then("a success message is displayed confirming the subscription")
    public void aSuccessMessageIsDisplayedConfirmingTheSubscription() throws InterruptedException {
        Thread.sleep(3000);
        WebElement successMessage = driver.findElement(By.xpath("//p[contains(@class, 'alert-success') and contains(text(), 'You have successfully subscribed to this newsletter.')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "El mensaje de éxito no fue mostrado.");
        driver.quit();
    }
}
