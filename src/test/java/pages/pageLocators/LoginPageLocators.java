package pages.pageLocators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By usernameFieldLocator = By.id("username");
    public static final By passwordFieldLocator = By.id("password");
    public static final By loginButtonLocator = By.xpath("//button[@type='submit']");
    public static final By pageBackgroundLocator = By.xpath("//div[@id='template']/div");
    public static final By errorMessageLocator = By.xpath("//strong[contains(text(),'Failed to sign in!')]");

}
