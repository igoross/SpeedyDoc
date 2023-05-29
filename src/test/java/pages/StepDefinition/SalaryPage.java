package pages.StepDefinition;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import helpers.getConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.pageLocators.SalaryPageLocators;

import java.io.Console;
import java.util.Objects;

public class SalaryPage {

    private Browser browser;
    private Page browserPage;
    private getConfig config;

    @Before
    public void setConfig(){
        config = new getConfig();
    }



    @Given("User is on the salary page")
    public void user_is_on_the_salary_page() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserPage = browser.newPage();
        browserPage.navigate(config.getBaseUrl());
    }

    @When("User choose {string} role")
    public void userChooseRole(String role) {
        Locator roleLoc = browserPage.locator(SalaryPageLocators.roleDropDown);
        roleLoc.fill(role);
    }
    @Then("User choose {string} dropdown item")
    public void userChoseDropdownItem(String dd){
        Locator dropDownFirstItemLoc = null;
        if (Objects.equals(dd, "Role")) {
            dropDownFirstItemLoc = browserPage.locator(SalaryPageLocators.roleDropDownFirstItem);
        }
        else if (Objects.equals(dd, "Country")){
            dropDownFirstItemLoc = browserPage.locator(SalaryPageLocators.countryDropDownFirstItem);
        }
        dropDownFirstItemLoc.click();
    }

    @When("User choose {string} country")
    public void user_choose_country(String country) {
        Locator countryLoc = browserPage.locator(SalaryPageLocators.countryDropDown);
        countryLoc.fill(country);
    }

    @When("User click on {string} button")
    public void user_click_button(String buttonName)
    {
        Locator searchButtonLoc = browserPage.locator(SalaryPageLocators.searchButton);
        searchButtonLoc.click();
    }

    @Then("User verify salary for {string} in {string} is displayed")
    public void userVerifySalaryForInIsDisplayed(String role, String country) {
        String pageText = browserPage.textContent(SalaryPageLocators.header);
        String expectedMessage = "Senior "+ role + " compensation in " + country;
        Assertions.assertTrue(pageText.contains(expectedMessage));
        browser.close();
    }

    @Then("User verify {string} is displayed")
    public void userVerifyIsDisplayed(String message) {
        String roleText = browserPage.textContent(SalaryPageLocators.failedSingInText);
        Assertions.assertTrue(roleText.contains(message));
        browser.close();
    }
}
