package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;

public class SideBarTest extends TestBase {
    LoginPage loginPage;
    SideBar sideBarTest;

    @BeforeMethod
    public void setUp() {
        initializerDriver();
        sideBarTest = new SideBar(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void clickOnMovieManagement() {
        loginPage.enterUsername("ABCAdmin"); // Correct credentials
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();

        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 001----------------\n");
        System.out.println("SIDE BAR TEST CASES : \n");

        sideBarTest.clickMovieManagement();

        String expectedText = "Movie Management";
        String actualText = sideBarTest.getTextMovieManagementHeading();

        if(expectedText.equals(actualText)) {
            System.out.println("\t + Movie Management heading is correct");
            System.out.println("\t + Verify Movie Management Side Bar: PASS\n\n");
        }
        else {
            System.out.println("\t + Movie Management heading is incorrect");
            System.out.println("\t + Verify Movie Management Side Bar: Fail\n\n");
        }
    }
}
