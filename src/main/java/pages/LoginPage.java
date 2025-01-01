package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    private By usernameField = By.xpath("//*[@id=\"username\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.xpath("/html/body/div[1]/form/button");
    private By mainHeading = By.xpath("/html/body/div[1]/main/header/h2");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }



    public String getMainHeadingText() {
        return driver.findElement(mainHeading).getText();
    }
}
