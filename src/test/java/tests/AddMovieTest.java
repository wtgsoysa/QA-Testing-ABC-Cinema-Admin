package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;

public class AddMovieTest extends TestBase {

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

        System.out.println("\n------------------------|| ABC_CINEMA_ADMIN_PANEL_ADD MOVIE_TEST || -----------------------\n");


        sideBarTest.clickMovieManagement();

        String expectedText = "Movie Management";
        String actualText = sideBarTest.getTextMovieManagementHeading();

        if (expectedText.equals(actualText)) {
            System.out.println("\t ------->  Navigate Movie Management Page Successfully\n\n");

        } else {
            System.out.println("\t ------->  Navigate Movie Management Page Unsuccessfully\n\n");

        }

        System.out.println("----------------TC 001----------------\n");
        System.out.println("ADD MOVIE TEST CASES : \n");


    }

}
