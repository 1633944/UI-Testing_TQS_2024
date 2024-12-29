package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {

    WebDriver driver;

    @Given("the user is on the contact us page")
    public void theUserIsOnTheContactUsPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
        Thread.sleep(10000);
        // Click en Contact us
        driver.findElement(By.linkText("Contact us")).click();
    }

    @When("^the user enters valid contact details: (.*), (.*)$")
    public void theUserEntersValidContactDetails(String email, String message) throws InterruptedException {
        Thread.sleep(3000);
        email = email.replace("\"", "");
        message = message.replace("\"", "");
        // Introducir correo electrónico
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(1000);
        // Introducir mensaje
        driver.findElement(By.id("contactform-message")).sendKeys(message);
    }

    @When("the user submits the contact us form")
    public void theUserSubmitsTheContactUsForm() throws InterruptedException {
        Thread.sleep(1000);
        // Click en botón Save
        driver.findElement(By.xpath("//input[@name='submitMessage']")).click();
    }

    @Then("the message is successfully sent")
    public void theMessageIsSuccessfullySent() throws InterruptedException {
        Thread.sleep(3000);
        WebElement signOutElement = driver.findElement(By.xpath("//div[@class='col-xs-12 alert alert-success']"));
        Assert.assertTrue(signOutElement.isDisplayed(), "El envio de mensaje no fue exitoso.");
    }
}
