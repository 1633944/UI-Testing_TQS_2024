package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarouselSteps {

    WebDriver driver;

    @Given("the user is on the homepage with a carousel")
    public void theUserIsOnTheHomepageWithACarousel() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.prestashop.com/");
        Thread.sleep(10000); // Esperar a que cargue la página
        driver.switchTo().frame("framelive");
    }

    @When("the user clicks the carousel s Next button")
    public void theUserClicksTheCarouselsNextButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement nextButton = driver.findElement(By.className("icon-next"));
        nextButton.click();
        Thread.sleep(2000); // Esperar a que se mueva el carousel
    }

    @Then("the second image is displayed")
    public void theSecondImageIsDisplayed() {
        WebElement secondImage = driver.findElement(By.xpath("//img[@alt='sample-2']"));
        Assert.assertTrue(secondImage.isDisplayed(), "The second image is not displayed");
    }
    
    @When("the user clicks the carousel s Next button again")
    public void theUserClicksTheCarouselsNextButtonAgain() throws InterruptedException {
        Thread.sleep(2000);
        WebElement nextButton = driver.findElement(By.className("icon-next"));
        nextButton.click();
        Thread.sleep(2000); // Esperar a que se mueva el carousel
    }

    @Then("the third image is displayed")
    public void theThirdImageIsDisplayed() {
        WebElement thirdImage = driver.findElement(By.xpath("//img[@alt='sample-3']"));
        Assert.assertTrue(thirdImage.isDisplayed(), "The third image is not displayed");
    }
    
    @When("the user clicks the carousel s Next button a third time")
    public void theUserClicksTheCarouselsNextButtonAThirdTime() throws InterruptedException {
        Thread.sleep(2000);
        WebElement nextButton = driver.findElement(By.className("icon-next"));
        nextButton.click();
        Thread.sleep(2000); // Esperar a que se mueva el carousel
    }

    @Then("the first image is displayed")
    public void theFirstImageIsDisplayed() {
        WebElement firstImage = driver.findElement(By.xpath("//img[@alt='sample-1']"));
        Assert.assertTrue(firstImage.isDisplayed(), "The first image is not displayed");
    }

    @When("the user clicks on the middle of the first image")
    public void theUserClicksOnTheMiddleOfTheFirstImage() {
        WebElement firstImage = driver.findElement(By.xpath("//img[@alt='sample-1']"));
        firstImage.click();
    }

    @Then("the user is navigated to the first image s details page")
    public void theUserIsNavigatedToTheFirstImagesDetailsPage() throws InterruptedException {
    	Thread.sleep(2000);
        WebElement banner = driver.findElement(By.cssSelector("section.banner.bg-light"));
        Assert.assertTrue(banner.isDisplayed(), "The user was not navigated to the first image's details page");
        driver.quit();
    }
}
