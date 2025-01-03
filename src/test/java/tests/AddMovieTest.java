package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddMoviePage;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;

public class AddMovieTest extends TestBase {

    LoginPage loginPage;
    SideBar sideBarTest;
    AddMoviePage addMoviePage;

    @BeforeMethod
    public void setUp() {
        initializerDriver();
        sideBarTest = new SideBar(driver);
        loginPage = new LoginPage(driver);
        addMoviePage = new AddMoviePage(driver);

        loginPage.enterUsername("ABCAdmin"); // Correct credentials
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();

    }

    @Test(priority = 1)
    public void addMovie() {

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

        addMoviePage.clickAddMovieBtn();

        String expectedText2 = "Add Your Movie Details";
        String actualText2 = addMoviePage.getAddMovieTitle();
        if (expectedText2.equals(actualText2)) {
            System.out.println("\t ------->  Navigate Add Movie Page Successfully\n\n");
        }
        else{
            System.out.println("\t ------->  Navigate Add Movie Page Unsuccessfully\n\n");
        }


    }

}
