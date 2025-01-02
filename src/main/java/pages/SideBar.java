package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBar {

    WebDriver driver;

    // Locators

    private By movieManagement = By.xpath("/html/body/div[1]/aside/nav/ul/li[1]/a");
    private By movieManagementHeading = By.xpath("/html/body/div[1]/main/header/h2");
    private By userManagement = By.xpath("/html/body/div[1]/aside/nav/ul/li[2]/a");
    private By userManagementHeading = By.xpath("/html/body/div[1]/main/header/h2");
    private By ticketManagement = By.xpath("/html/body/div[1]/aside/nav/ul/li[3]/a");
    private By ticketManagementHeading = By.xpath("/html/body/div[1]/main/header/h2");
    private By reviewManagement = By.xpath("/html/body/div[1]/aside/nav/ul/li[4]/a");
    private By logoutBtn = By.xpath("/html/body/div[1]/aside/nav/ul/li[5]/a");
    private By logoutHeading = By.xpath("/html/body/div/p");

    // Constructor
    public SideBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMovieManagement() {
        driver.findElement(movieManagement).click();
    }

    public String getTextMovieManagementHeading() {

        return driver.findElement(movieManagementHeading).getText();
    }

    public void clickUserManagement() {
        driver.findElement(userManagement).click();
    }

    public String getTextUserManagementHeading() {
        return driver.findElement(userManagementHeading).getText();
    }

    public void clickTicketManagement() {
        driver.findElement(ticketManagement).click();
    }

    public String getTextTicketManagementHeading() {
        return driver.findElement(ticketManagementHeading).getText();
    }

    public void clickReviewManagement() {
        driver.findElement(reviewManagement).click();

    }

    public String getTextReviewManagementHeading() {
        return driver.findElement(reviewManagement).getText();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }

    public String getTextLogoutHeading() {
        return driver.findElement(logoutHeading).getText();
    }




}
