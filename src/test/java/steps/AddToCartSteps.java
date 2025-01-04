package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

    WebDriver driver;

    @Given("the user is on the product details page")
    public void theUserIsOnTheProductDetailsPage() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        driver.switchTo().frame("framelive");

        // Navegar al producto específico (por ejemplo, "Hummingbird Printed T-Shirt")
        try {
            Thread.sleep(10000); // Esperar que cargue la página
            WebElement productLink = driver.findElement(By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]"));
            productLink.click();
            Thread.sleep(5000); // Esperar que cargue la página del producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the user clicks on Add to Cart")
    public void theUserClicksOnAddToCart() throws InterruptedException {
        // Hacer clic en el botón "Add to cart"
        Thread.sleep(2000); // Esperar que el botón esté disponible
        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart"));
        addToCartButton.click();
        Thread.sleep(2000); // Esperar que aparezca el modal de confirmación
    }

    @Then("the product is added to the cart with a confirmation message")
    public void theProductIsAddedToTheCartWithAConfirmationMessage() throws InterruptedException {
        Thread.sleep(2000); // Espera a que el modal de confirmación sea visible

        // Localizar el mensaje de confirmación en el modal
        WebElement confirmationMessage = driver.findElement(By.id("myModalLabel"));

        // Verificar que el mensaje es correcto
        String expectedMessage = "Product successfully added to your shopping cart";
        Assert.assertEquals(confirmationMessage.getText().trim(), expectedMessage, "El mensaje de confirmación no coincide.");

        // Cerrar el navegador
        driver.quit();
    }
}
