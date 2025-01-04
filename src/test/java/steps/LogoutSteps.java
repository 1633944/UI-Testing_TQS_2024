package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoutSteps {

    WebDriver driver;

    @Given("the user is on the registration page for logout")
    public void theUserIsOnTheRegistrationPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
        Thread.sleep(13000);
        // Click en Sign in
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(3000);
        // Click en "No account? Create one here"
        driver.findElement(By.linkText("No account? Create one here")).click();
    }

    @When("^the user enters valid registration details for logout: (.*), (.*), (.*), (.*)$")
    public void theUserEntersValidRegistrationDetails(String firstName, String lastName, String email, String password) throws InterruptedException {
        Thread.sleep(3000);
        firstName = firstName.replace("\"", "");
        lastName = lastName.replace("\"", "");
        email = email.replace("\"", "");
        password = password.replace("\"", "");
    	// Seleccionar título "Mr"
        driver.findElement(By.xpath("//input[@id='field-id_gender-1']")).click();
        Thread.sleep(1000);
        // Introducir nombre
        driver.findElement(By.id("field-firstname")).sendKeys(firstName);
        Thread.sleep(1000);
        // Introducir apellido
        driver.findElement(By.id("field-lastname")).sendKeys(lastName);
        Thread.sleep(1000);
        // Introducir correo electrónico
        driver.findElement(By.id("field-email")).sendKeys(email);
        Thread.sleep(1000);
        // Introducir contraseña
        driver.findElement(By.id("field-password")).sendKeys(password);
        Thread.sleep(1000);
        // Click en "I agree to the terms and conditions and the privacy policy"
        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        Thread.sleep(1000);
        // Click en "Customer data privacy"
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();
    }

    @When("the user submits the registration form for logout")
    public void theUserSubmitsTheRegistrationForm() throws InterruptedException {
        Thread.sleep(1000);
        // Click en botón Save
        driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Save')]")).click();
    }
    
    @When("the user clicks on sign out")
    public void theUserClicksOnSignOut() throws InterruptedException {
        Thread.sleep(3000);
        // Click en botón Save
        driver.findElement(By.id("_desktop_user_info")).click();
    }
    
    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() throws InterruptedException {
        Thread.sleep(3000);

        // Verificar que se muestra "Sign in"
        WebElement signOutElement = driver.findElement(By.linkText("Sign in"));
        Assert.assertTrue(signOutElement.isDisplayed(), "Sign Out no exitoso.");
    }
    
}
