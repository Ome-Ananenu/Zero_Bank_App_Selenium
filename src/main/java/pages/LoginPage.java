package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private ChromeDriver driver;
    private String loginUsernameId = "user_login";
    private String loginPasswordId = "user_password";
    private String signInBtnId = "input[name = 'submit']";
    private String errorAlertId = "div[class='alert alert-error']";

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(String username, String password){
        WebElement usernameField = driver.findElementById(loginUsernameId);
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElementById(loginPasswordId);
        passwordField.sendKeys(password);

        driver.findElementByCssSelector(signInBtnId).click();
    }

    public String checkErrorMssg(){
        return driver.findElementByCssSelector(errorAlertId).getText();
    }
}
