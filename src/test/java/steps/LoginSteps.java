package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
        Thread.sleep(10000);
        WebElement signInLink = driver.findElement(By.xpath("//a[contains(@href, 'login')]"));
        signInLink.click();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) throws InterruptedException {
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("field-email"));
        emailField.clear();
        emailField.sendKeys(username);
    }

    @When("I enter the password {string}")
    public void iEnterThePassword(String password) throws InterruptedException {
        Thread.sleep(3000);
        WebElement passwordField = driver.findElement(By.id("field-password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("I log in")
    public void iLogIn() throws InterruptedException {
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        WebElement userDashboard = driver.findElement(By.xpath("//a[contains(@href, 'my-account')]"));
        Assert.assertTrue(userDashboard.isDisplayed(), "El usuario no ha iniciado sesión correctamente.");
        driver.quit();
    }

    @Then("I should see the login error message {string}")
    public void iShouldSeeTheLoginErrorMessage(String errorMessage) {
        WebElement errorAlert = driver.findElement(By.cssSelector(".alert-danger"));
        Assert.assertTrue(errorAlert.isDisplayed(), "No se muestra el mensaje de error.");
        Assert.assertEquals(errorAlert.getText().trim(), errorMessage, "El mensaje de error no coincide.");
        driver.quit();
    }

    @Then("I should not be able to log in and should be reminded by the page to complete the field")
    public void iShouldNotBeAbleToLogInAndShouldBeRemindedByThePageToCompleteTheField() {
        WebElement fieldError = driver.findElement(By.cssSelector(".form-control-feedback"));
        Assert.assertTrue(fieldError.isDisplayed(), "No se muestra el recordatorio para completar el campo.");
        driver.quit();
    }
}
