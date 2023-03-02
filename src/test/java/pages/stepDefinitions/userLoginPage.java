package pages.stepDefinitions;


import helpers.getConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static pages.pageLocators.LoginPageLocators.*;

import java.io.FileNotFoundException;
import java.time.Duration;


import static helpers.BaseHelperDriver.getDriver;


public class userLoginPage {
    private final getConfig config = new getConfig();


    WebDriver driver = getDriver();

    public userLoginPage() throws FileNotFoundException {
    }


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get(config.getBaseUrl());
        driver.manage().window().maximize();
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        driver.findElement(usernameFieldLocator).sendKeys(config.getValidUsername());
        driver.findElement(passwordFieldLocator).sendKeys(config.getValidPassword());

    }

    @When("User click on the Login button")
    public void user_click_on_the_Login_button() {
        driver.findElement(loginButtonLocator).click();
    }

    @Then("User should be redirected to the home page$")
    public void user_should_be_redirected_to_the_home_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageBackgroundLocator));
        WebElement SpeedyApp = driver.findElement(pageBackgroundLocator);
        Assert.assertTrue(SpeedyApp.getText().contains("Molba za hitno izdavanje"));
        System.out.println("the user is successfully logged in on web page" + SpeedyApp.getText());
        driver.quit();
    }

    @When("^User enters invalid credentials$")
    public void user_enters_invalid_credentials() {
        driver.findElement(usernameFieldLocator).sendKeys(config.getInvalidUsername());
        driver.findElement(passwordFieldLocator).sendKeys(config.getInvalidPassword());
    }

    @Then("^User should see an error message$")
    public void user_should_see_an_error_message() {
        String expectedErrorMessage = "Failed to sign in!";
        String actualErrorMessage = driver.findElement(errorMessageLocator).getText();
        String actualMessage = driver.findElement(errorMessageLocator).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("The user is: " + expectedErrorMessage);
        driver.quit();
    }
}
