package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistSteps {

    WebDriver driver;

    @Given("the user is on the registration page for wishlist")
    public void theUserIsOnTheRegistrationPageForWishlist() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");
        Thread.sleep(10000);
        // Click en Sign in
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(3000);
        // Click en "No account? Create one here"
        driver.findElement(By.linkText("No account? Create one here")).click();
    }

    @When("^the user enters valid registration details for wishlist: (.*), (.*), (.*), (.*)$")
    public void theUserEntersValidRegistrationDetailsForWishlist(String firstName, String lastName, String email, String password) throws InterruptedException {
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

    @When("the user submits the registration form for wishlist")
    public void theUserSubmitsTheRegistrationFormForWishlist() throws InterruptedException {
        Thread.sleep(1000);
        // Click en botón Save
        driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Save')]")).click();
    }

    @When("the user adds a product to the wishlist")
    public void theUserAddsAProductToTheWishlist() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".wishlist-button-add i")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("wishlist-chooselist")).click();
        Thread.sleep(2000);
    }
    
    @When("the user navigates to the \"My wishlists\" section")
    public void theUserNavigatesToTheMyWishlistsSection() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("account")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("wishlist-link")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("wishlist-list-container")).click();
    }

    @Then("the user verifies the product appears in the wishlist")
    public void theUserVerifiesTheProductAppearsInTheWishlist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement wishlistItem = driver.findElement(By.cssSelector(".wishlist-products-list .wishlist-products-item"));
        Assert.assertTrue(wishlistItem.isDisplayed(), "Product is not displayed in the wishlist");
        driver.quit();
    }

}
