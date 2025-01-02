package tests;

import org.testng.Assert;
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

        loginPage.enterUsername("ABCAdmin"); // Correct credentials
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();

    }

    @Test(priority = 1)
    public void clickOnMovieManagement() {

        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 001----------------\n");
        System.out.println("SIDE BAR MOVIE MANAGEMENT TEST CASES : \n");

        sideBarTest.clickMovieManagement();

        String expectedText = "Movie Management";
        String actualText = sideBarTest.getTextMovieManagementHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t + Movie Management heading is correct");
            System.out.println("\t + Verify Movie Management Side Bar: PASS\n\n");
        } else {
            System.out.println("\t + Movie Management heading is incorrect");
            System.out.println("\t + Verify Movie Management Side Bar: Fail\n\n");
        }
    }
    @Test(priority = 2)
    public void clickOnUserManagement() {
        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 002----------------\n");
        System.out.println("SIDE BAR USER MANAGEMENT TEST CASES : \n");

        sideBarTest.clickUserManagement();

        String expectedText = "User Management";
        String actualText = sideBarTest.getTextUserManagementHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t + User Management heading is correct");
            System.out.println("\t + Verify User Management Side Bar: PASS\n\n");
        } else {
            System.out.println("\t + User Management heading is incorrect");
            System.out.println("\t + Verify User Management Side Bar: Fail\n\n");
        }
    }

    @Test(priority = 3)
    public void clickOnTicketManagement() {
        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 003----------------\n");
        System.out.println("SIDE BAR TICKET MANAGEMENT TEST CASES : \n");

        sideBarTest.clickTicketManagement();

        String expectedText = "Ticket Management";
        String actualText = sideBarTest.getTextTicketManagementHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t + User Management heading is correct");
            System.out.println("\t + Verify User Management Side Bar: PASS\n\n");
        } else {
            System.out.println("\t + User Management heading is incorrect");
            System.out.println("\t + Verify User Management Side Bar: Fail\n\n");
        }
    }

    @Test(priority = 4)
    public void clickOnReviewManagement() {
        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 004----------------\n");
        System.out.println("SIDE BAR REVIEW MANAGEMENT TEST CASES : \n");

        sideBarTest.clickReviewManagement();

        String expectedText = "Review Management";
        String actualText = sideBarTest.getTextReviewManagementHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t + Review Management heading is correct");
            System.out.println("\t + Verify Review Management Side Bar: PASS\n\n");
        } else {
            System.out.println("\t + Review Management heading is incorrect");
            System.out.println("\t + Verify Review Management Side Bar: Fail\n\n");
        }
    }

    @Test(priority = 5)
    public void clickOnLogout() {
        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_SIDEBAR_TEST || -----------------------\n");
        System.out.println("----------------TC 005----------------\n");
        System.out.println("SIDE BAR LOGOUT TEST CASES : \n");

        sideBarTest.clickLogout();

        String expectedText = "Login as Admin";
        String actualText = sideBarTest.getTextLogoutHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t + Logout heading is correct");
            System.out.println("\t + Verify Logout Side Bar: PASS\n\n");
        } else {
            System.out.println("\t + Logout heading is incorrect");
            System.out.println("\t + Verify Logout Side Bar: Fail\n\n");
        }
    }




}







