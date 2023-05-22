package pages.StepDefinition;

import com.microsoft.playwright.*;
import helpers.getConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.pageLocators.LoginPageLocators;
import pages.pageLocators.TextAssertLocators;

public class userLoginPage {

    private Browser browser;
    private Page page;
    private getConfig config;

    @Before
    public void setConfig(){
        config = new getConfig();
    }



    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(config.getBaseUrl());
    }
    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        Locator usernameField = page.locator(LoginPageLocators.usernameField);
        String username = config.getValidUsername();
        usernameField.fill(username);
        Locator passwordField = page.locator(LoginPageLocators.passwordField);
        String password = config.getValidPassword();
        passwordField.fill(password);
    }
    @When("User click on the Login button")
    public void user_click_on_the_login_button() {
        Locator loginBtn = page.locator(LoginPageLocators.loginButton);
        loginBtn.hover();
        loginBtn.click();
    }
    @Then("User should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        String loggedInUser = page.title();
        System.out.println("page title is: "+loggedInUser);
    }
    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials(){
        Locator usernameField = page.locator(LoginPageLocators.usernameField);
        String username = config.getInvalidUsername();
        usernameField.fill(username);
        Locator passwordField = page.locator(LoginPageLocators.passwordField);
        String password = config.getInvalidPassword();
        passwordField.fill(password);

    }
    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        String pageText = page.textContent(TextAssertLocators.failedSingInText);
        System.out.println("Page text content: " + pageText);
        String expectedMessage = "Failed to sign in!";
        Assertions.assertTrue(pageText.contains(expectedMessage));
        browser.close();
    }

}
