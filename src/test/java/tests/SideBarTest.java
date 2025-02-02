package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;
import utils.ExtentManager;

public class SideBarTest extends TestBase {
    LoginPage loginPage;
    SideBar sideBarTest;
    ExtentTest test;

    @BeforeMethod
    public void setUp() {
        initializerDriver();
        sideBarTest = new SideBar(driver);
        loginPage = new LoginPage(driver);

        // Login with valid credentials
        loginPage.enterUsername("ABCAdmin");
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();
    }

    @Test(priority = 1)
    public void clickOnMovieManagement() {
        test = ExtentManager.getInstance().createTest("TC 001 - Movie Management");

        sideBarTest.clickMovieManagement();

        String expectedText = "Movie Management";
        String actualText = sideBarTest.getTextMovieManagementHeading();

        // Using ExtentReports for logging test results
        if (expectedText.equals(actualText)) {
            test.pass("Movie Management heading is correct");
            System.out.println("\t + Movie Management heading is correct");
        } else {
            test.fail("Movie Management heading is incorrect");
            System.out.println("\t + Movie Management heading is incorrect");
        }

        Assert.assertEquals(actualText, expectedText, "Movie Management heading mismatch");
    }

    @Test(priority = 2)
    public void clickOnUserManagement() {
        test = ExtentManager.getInstance().createTest("TC 002 - User Management");

        sideBarTest.clickUserManagement();

        String expectedText = "User Management";
        String actualText = sideBarTest.getTextUserManagementHeading();

        // Using ExtentReports for logging test results
        if (expectedText.equals(actualText)) {
            test.pass("User Management heading is correct");
        } else {
            test.fail("User Management heading is incorrect");
        }

        Assert.assertEquals(actualText, expectedText, "User Management heading mismatch");
    }

    @Test(priority = 3)
    public void clickOnTicketManagement() {
        test = ExtentManager.getInstance().createTest("TC 003 - Ticket Management");

        sideBarTest.clickTicketManagement();

        String expectedText = "Ticket Management";
        String actualText = sideBarTest.getTextTicketManagementHeading();

        // Using ExtentReports for logging test results
        if (expectedText.equals(actualText)) {
            test.pass("Ticket Management heading is correct");
        } else {
            test.fail("Ticket Management heading is incorrect");
        }

        Assert.assertEquals(actualText, expectedText, "Ticket Management heading mismatch");
    }

    @Test(priority = 4)
    public void clickOnReviewManagement() {
        test = ExtentManager.getInstance().createTest("TC 004 - Review Management");

        sideBarTest.clickReviewManagement();

        String expectedText = "Review Management";
        String actualText = sideBarTest.getTextReviewManagementHeading();

        // Using ExtentReports for logging test results
        if (expectedText.equals(actualText)) {
            test.pass("Review Management heading is correct");
        } else {
            test.fail("Review Management heading is incorrect");
        }

        Assert.assertEquals(actualText, expectedText, "Review Management heading mismatch");
    }

    @Test(priority = 5)
    public void clickOnLogout() {
        test = ExtentManager.getInstance().createTest("TC 005 - Logout");

        sideBarTest.clickLogout();

        String expectedText = "Login as Admin";
        String actualText = sideBarTest.getTextLogoutHeading();

        // Using ExtentReports for logging test results
        if (expectedText.equals(actualText)) {
            test.pass("Logout heading is correct");
        } else {
            test.fail("Logout heading is incorrect");
        }

        Assert.assertEquals(actualText, expectedText, "Logout heading mismatch");
    }

    @AfterMethod
    public void tearDown() {
        ExtentManager.flushReports();
        driver.quit();
    }
}
