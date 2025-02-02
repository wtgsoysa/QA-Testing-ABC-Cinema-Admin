package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddMoviePage;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;
import utils.ExtentManager;

public class AddMovieTest extends TestBase {

    LoginPage loginPage;
    SideBar sideBarTest;
    AddMoviePage addMoviePage;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        initializerDriver();
        sideBarTest = new SideBar(driver);
        loginPage = new LoginPage(driver);
        addMoviePage = new AddMoviePage(driver);

        // Start the extent report for the test
        test = ExtentManager.createTest("Add Movie Test - Validate Movie Addition and Details")
                .assignCategory("Admin Panel");

        // Login with valid credentials
        loginPage.enterUsername("ABCAdmin");
        loginPage.enterPassword("ABCAdmin123");
        loginPage.clickLogin();
        test.log(Status.INFO, "Logged in with valid credentials.");
    }

    @Test(priority = 1)
    public void addMovie() {
        test.log(Status.INFO, "Navigating to Movie Management page.");
        sideBarTest.clickMovieManagement();

        String expectedText = "Movie Management";
        String actualText = sideBarTest.getTextMovieManagementHeading();
        logNavigationStatus(expectedText, actualText);

        test.log(Status.INFO, "Starting Add Movie Test Case");

        addMoviePage.clickAddMovieBtn();

        String expectedText2 = "Add Your Movie Details";
        String actualText2 = addMoviePage.getAddMovieTitle();
        logNavigationStatus(expectedText2, actualText2);

        // Search by Movie Title --> The Wild Robot
        addMoviePage.searchMovieTitle("The Wild Robot");
        addMoviePage.clickSearchMovieBtn();

        test.log(Status.INFO, "Searching for Movie 'The Wild Robot' in English.");
        validateMovieDetails("The Wild Robot", "108 minutes", "8.0",
                "Seoul, South Korea, 1997...", "Thriller, Mystery, Crime");

        // Remove the search movie
        addMoviePage.clickSearchMovieBtn();

        // Search by Movie Title --> Forgotten
        addMoviePage.searchMovieTitle("기억의 밤");
        addMoviePage.clickSearchMovieBtn();

        test.log(Status.INFO, "Searching for Movie 'Forgotten' in Korean.");
        validateMovieDetails("Forgotten", "108 minutes", "8.0",
                "Seoul, South Korea, 1997...", "Thriller, Mystery, Crime");

        // Remove the search movie
        addMoviePage.clickSearchMovieBtn();

        // Search by Movie Title --> Suhada Koka
        addMoviePage.searchMovieTitle("සුහද කොකා");
        addMoviePage.clickSearchMovieBtn();

        test.log(Status.INFO, "Searching for Movie 'Suhada Koka' in Sinhala.");
        validateMovieDetails("Suhada Koka", "122 minutes", "9.0",
                "The film starts with a release...", "Comedy");
    }

    private void validateMovieDetails(String expectedTitle, String expectedRuntime, String expectedImdb,
                                      String expectedDescription, String expectedGenres) {
        String actualTitle = addMoviePage.getMovieTitle01();
        String actualRuntime = addMoviePage.getRuntime();
        String actualImdb = addMoviePage.getImdb();
        String actualDescription = addMoviePage.getDescription();
        String actualGenres = addMoviePage.getGenres();

        if (expectedTitle.equals(actualTitle)) {
            test.log(Status.PASS, "Movie Title matched: " + actualTitle);
        } else {
            test.log(Status.FAIL, "Movie Title mismatch: Expected - " + expectedTitle + ", Actual - " + actualTitle);
        }

        if (expectedRuntime.equals(actualRuntime)) {
            test.log(Status.PASS, "Movie Runtime matched: " + actualRuntime);
        } else {
            test.log(Status.FAIL, "Movie Runtime mismatch: Expected - " + expectedRuntime + ", Actual - " + actualRuntime);
        }

        if (expectedImdb.equals(actualImdb)) {
            test.log(Status.PASS, "Movie IMDB Rating matched: " + actualImdb);
        } else {
            test.log(Status.FAIL, "Movie IMDB Rating mismatch: Expected - " + expectedImdb + ", Actual - " + actualImdb);
        }

        if (expectedDescription.equals(actualDescription)) {
            test.log(Status.PASS, "Movie Description matched: " + actualDescription);
        } else {
            test.log(Status.FAIL, "Movie Description mismatch: Expected - " + expectedDescription + ", Actual - " + actualDescription);
        }

        if (expectedGenres.equals(actualGenres)) {
            test.log(Status.PASS, "Movie Genres matched: " + actualGenres);
        } else {
            test.log(Status.FAIL, "Movie Genres mismatch: Expected - " + expectedGenres + ", Actual - " + actualGenres);
        }
    }

    @Test(priority = 2)
    public void validateDropdownOptions() {
        test.log(Status.INFO, "Starting Dropdown Validation Test Case.");

        addMoviePage.clickAddMovieBtn();

        String expectedText2 = "Add Your Movie Details";
        String actualText2 = addMoviePage.getAddMovieTitle();
        logNavigationStatus(expectedText2, actualText2);

        // Add Dropdown validation logic here
    }

    private void logNavigationStatus(String expected, String actual) {
        if (expected.equals(actual)) {
            test.log(Status.PASS, "Navigation successful: " + expected);
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
