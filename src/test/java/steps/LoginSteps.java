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

    @Given("the user is on the login page")
    public void TheUserIsOnTheLoginPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
        Thread.sleep(10000);
        WebElement signInLink = driver.findElement(By.xpath("//a[contains(@href, 'login')]"));
        signInLink.click();
    }

    @When("the user enter the username {string}")
    public void TheUserEnterTheUsername(String username) throws InterruptedException {
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("field-email"));
        emailField.clear();
        emailField.sendKeys(username);
    }

    @When("the user enter the password {string}")
    public void TheUserEnterThePassword(String password) throws InterruptedException {
        Thread.sleep(3000);
        WebElement passwordField = driver.findElement(By.id("field-password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("the user log in")
    public void TheUserLogIn() throws InterruptedException {
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
    }

    @Then("the user should be logged in")
    public void TheUserShouldBeLoggedIn() {
        WebElement userDashboard = driver.findElement(By.xpath("//a[contains(@href, 'my-account')]"));
        Assert.assertTrue(userDashboard.isDisplayed(), "El usuario no ha iniciado sesión correctamente.");
        driver.quit();
    }

    @Then("the user should see the login error message {string}")
    public void TheUserShouldSeeTheLoginErrorMessage(String errorMessage) {
        WebElement errorAlert = driver.findElement(By.cssSelector(".alert-danger"));
        Assert.assertTrue(errorAlert.isDisplayed(), "No se muestra el mensaje de error.");
        Assert.assertEquals(errorAlert.getText().trim(), errorMessage, "El mensaje de error no coincide.");
        driver.quit();
    }

    @Then("the user should not be able to log in and should be reminded by the page to complete the field")
    public void TheUserShouldNotBeAbleToLogInAndShouldBeRemindedByThePageToCompleteTheField() {
        WebElement fieldError = driver.findElement(By.cssSelector(".form-control-feedback"));
        Assert.assertTrue(fieldError.isDisplayed(), "No se muestra el recordatorio para completar el campo.");
        driver.quit();
    }
}
