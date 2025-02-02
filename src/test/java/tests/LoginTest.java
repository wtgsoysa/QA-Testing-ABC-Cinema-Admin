package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import testBase.TestBase;
import utils.ExtentManager;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        initializerDriver(); // Initializes the WebDriver for the test
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testValidLogin() {
        test = ExtentManager.createTest("Login Test - Valid Credentials")
                .assignCategory("Admin Authentication");

        test.log(Status.INFO, "Starting Login with Correct Credentials Test");

        // Providing correct credentials for valid login
        loginPage.enterUsername("ABCAdmin");
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();

        // Verifying main heading text after successful login
        String expectedText = "Movie Management";
        String actualText = loginPage.getMainHeadingText();

        logNavigationStatus(expectedText, actualText);

        // Adding assertion to ensure the test fails if the login is unsuccessful
        Assert.assertEquals(actualText, expectedText, "Admin login unsuccessful! Heading mismatch.");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        test = ExtentManager.createTest("Login Test - Invalid Credentials")
                .assignCategory("Admin Authentication");

        test.log(Status.INFO, "Starting Login with Invalid Credentials Test");

        // Providing incorrect credentials for invalid login
        loginPage.enterUsername("WrongAdmin");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickLogin();

        // Assuming the login should fail and there won't be any main heading text
        try {
            String actualText = loginPage.getMainHeadingText();
            test.log(Status.FAIL, "Login should fail, but the heading was found: " + actualText);
            Assert.fail("Login should fail, but the heading was found: " + actualText);
        } catch (Exception e) {
            // Catching exception when the heading text is not found, indicating failure as expected
            test.log(Status.PASS, "Admin login into the admin panel Unsuccessfully as expected.");
            test.log(Status.PASS, "Invalid credentials test case: PASS");
        }
    }

    private void logNavigationStatus(String expected, String actual) {
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Successfully navigated: " + expected);
        } else {
            test.log(Status.FAIL, "Navigation failed: Expected '" + expected + "', but got '" + actual + "'");
        }
    }

    @AfterMethod
    public void tearDown() {
        ExtentManager.flushReports();
        driver.quit();
    }
}
