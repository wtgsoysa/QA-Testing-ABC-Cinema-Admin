package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddMoviePage;
import pages.LoginPage;
import pages.SideBar;
import testBase.TestBase;

import java.util.List;

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
        } else {
            System.out.println("\t ------->  Navigate Add Movie Page Unsuccessfully\n\n");
        }

        //Search by Movie Title --> The Wild Robot
        addMoviePage.searchMovieTitle("The Wild Robot");
        addMoviePage.clickSearchMovieBtn();

        System.out.println("Search Movie 01 : The Wild Robot (English Language): \n");

        String expectedMovieTitle = "The Wild Robot";
        String actualMovieTitle = addMoviePage.getMovieTitle01();

        if (expectedMovieTitle.equals(actualMovieTitle)) {
            System.out.println("\t + Search Movie 01 Successfully Retrieve from API -->");
            System.out.println("\t + " + actualMovieTitle + " Test Passed");
        } else {
            System.out.println("\t + Search Movie 01 Unsuccessfully Retrieve from API\n\n");
            System.out.println("\t + " + actualMovieTitle + " Test Failed");
        }

        //Remove the search movie
        addMoviePage.clickSearchMovieBtn();


        System.out.println("\n\nDifferent languages movie search : \n");

        //Search by Movie Title --> Forgotten
        addMoviePage.searchMovieTitle("기억의 밤");
        addMoviePage.clickSearchMovieBtn();

        System.out.println("Search Movie 02 : 기억의 밤 (Korean Language) / Forgotten: \n");

        String expectedMovieTitle01 = "Forgotten";
        String actualMovieTitle01 = addMoviePage.getMovieTitle01();

        String expectedMovieRuntime = "108 minutes";
        String actualMovieRuntime = addMoviePage.getRuntime();

        String expectedMovieImdb = "8.0";
        String actualMovieImdb = addMoviePage.getImdb();

        String expectedMovieDescription = "Seoul, South Korea, 1997. When the young but extremely anxious student Jin-seok, his parents and his successful older brother Yoo-seok move to a new home, mysterious and frightening events begin to happen around them, unexplained events that threaten to ruin their seemingly happy lives. Unable to understand what is happening, Jin-seok wonders if he is losing his mind.";
        String actualMovieDescription = addMoviePage.getDescription();

        String expectedMovieGenres = "Thriller, Mystery, Crime";
        String actualMovieGenres = addMoviePage.getGenres();



        if (expectedMovieTitle01.equals(actualMovieTitle01)) {
            System.out.println("\t + Search Movie Successfully Retrieve from API -->");
            System.out.println("\t + " + actualMovieTitle01 + " Test Passed");

            System.out.println("\t + Movie Data : \n" );
            System.out.println("\t + " + actualMovieRuntime);
            System.out.println("\t + " + actualMovieImdb);
            System.out.println("\t + " + actualMovieDescription);
            System.out.println("\t + " + actualMovieGenres);

            if(expectedMovieRuntime.equals(actualMovieRuntime)) {
                System.out.println("\t + Search Movie Runtime Successfully");

                if(expectedMovieImdb.equals(actualMovieImdb)) {
                    System.out.println("\t + Search Movie Imdb Successfully");

                    if(expectedMovieDescription.equals(actualMovieDescription)) {
                        System.out.println("\t + Search Movie Description Successfully");

                        if(expectedMovieGenres.equals(actualMovieGenres)) {
                            System.out.println("\t + Search Movie Genres Successfully");
                        }
                        else{
                            System.out.println("\t + Search Movie Genres Unsuccessfully");
                        }
                    }
                    else{
                        System.out.println("\t + Search Movie Description Unsuccessfully");
                    }
                }
                else {
                    System.out.println("\t + Search Movie Imdb Unsuccessfully");
                }
            }
            else {
                System.out.println("\t + Search Movie Runtime Unsuccessfully");
            }




        } else {
            System.out.println("\t + Search Movie Unsuccessfully Retrieve from API\n\n");
            System.out.println("\t + " + actualMovieTitle01 + " Test Failed");
        }

        //Remove the search movie
        addMoviePage.clickSearchMovieBtn();

        //Search by Movie Title --> Forgotten
        addMoviePage.searchMovieTitle("සුහද කොකා");
        addMoviePage.clickSearchMovieBtn();

        System.out.println("\n\n Search Movie 03 : සුහද කොකා (Sinhala Language) / Suhada Koka : \n");

        String expectedMovieTitle02 = "Suhada Koka";
        String actualMovieTitle02 = addMoviePage.getMovieTitle01();

        String expectedMovieRuntime02 = "122 minutes";
        String actualMovieRuntime02 = addMoviePage.getRuntime();

        String expectedMovieImdb02 = "9.0";
        String actualMovieImdb02 = addMoviePage.getImdb();

        String expectedMovieDescription02 = "The film starts with a release of peoples' vote of government election, where Rajamanthri (Vijaya) lost his seat and crying with his allies. However, his secretary Sumanasiri (Rodney) revealed that the winning member has been hospitalized after hearing the shocking news of that he won the election of the seat. Rajamanthri and crew went to the hospital and finally the winning member died and Rajamanthri won the seat. After winning the seat, he started to celebrate the win, but his fellow ministers (Priyantha and Jayasiri) started to make actions against him. However, with many funny incidents, Rajamanthri pass all the battles with the help of his allies. Meanwhile, Liyana Mahaththaya (Lal), clark (Mihira) and Kalu mudalali (Giriraj) proposed an Awurudu Ulela to impress Chief minister Narendrasinghe (Sathischandra).";
        String actualMovieDescription02 = addMoviePage.getDescription();

        String expectedMovieGenres02 = "Comedy";
        String actualMovieGenres02 = addMoviePage.getGenres();



        if (expectedMovieTitle02.equals(actualMovieTitle02)) {
            System.out.println("\t + Search Movie Successfully Retrieve from API -->");
            System.out.println("\t + " + actualMovieTitle02 + " Test Passed");

            System.out.println("\t + Movie Data : \n" );
            System.out.println("\t + " + actualMovieRuntime02);
            System.out.println("\t + " + actualMovieImdb02);
            System.out.println("\t + " + actualMovieDescription02);
            System.out.println("\t + " + actualMovieGenres02);

            if(expectedMovieRuntime02.equals(actualMovieRuntime02)) {
                System.out.println("\t + Search Movie Runtime Successfully");

                if(expectedMovieImdb02.equals(actualMovieImdb02)) {
                    System.out.println("\t + Search Movie Imdb Successfully");

                    if(expectedMovieDescription02.equals(actualMovieDescription02)) {
                        System.out.println("\t + Search Movie Description Successfully");

                        if(expectedMovieGenres02.equals(actualMovieGenres02)) {
                            System.out.println("\t + Search Movie Genres Successfully");
                        }
                        else{
                            System.out.println("\t + Search Movie Genres Unsuccessfully");
                        }
                    }
                    else{
                        System.out.println("\t + Search Movie Description Unsuccessfully");
                    }
                }
                else {
                    System.out.println("\t + Search Movie Imdb Unsuccessfully");
                }
            }
            else {
                System.out.println("\t + Search Movie Runtime Unsuccessfully");
            }




        } else {
            System.out.println("\t + Search Movie Unsuccessfully Retrieve from API\n\n");
            System.out.println("\t + " + actualMovieTitle02 + " Test Failed");
        }





    }

    @Test(priority = 2)
    public void validateDropdownOptions(){


        System.out.println("----------------TC 002----------------\n");
        System.out.println("VALIDATE DROPDOWN TEST CASES : \n");

        addMoviePage.clickAddMovieBtn();

        String expectedText2 = "Add Your Movie Details";
        String actualText2 = addMoviePage.getAddMovieTitle();
        if (expectedText2.equals(actualText2)) {
            System.out.println("\t ------->  Navigate Add Movie Page Successfully\n\n");
        } else {
            System.out.println("\t ------->  Navigate Add Movie Page Unsuccessfully\n\n");
        }

        //Search by Movie Title --> The Wild Robot
        addMoviePage.searchMovieTitle("The Green Mile");
        addMoviePage.clickSearchMovieBtn();

        System.out.println("Search Movie 01 : The Green Mile (English Language): \n");

        String expectedMovieTitle = "The Green Mile";
        String actualMovieTitle = addMoviePage.getMovieTitle01();

        if (expectedMovieTitle.equals(actualMovieTitle)) {
            System.out.println("\t + Search Movie 01 Successfully Retrieve from API -->");
            System.out.println("\t + " + actualMovieTitle + " Test Passed");
        } else {
            System.out.println("\t + Search Movie 01 Unsuccessfully Retrieve from API\n\n");
            System.out.println("\t + " + actualMovieTitle + " Test Failed");
        }

        System.out.println("\n------------------------|| DROPDOWN OPTIONS VALIDATION || -----------------------\n");

        // Define the expected options
        List<String> expectedOptions = List.of("Screening Now Home", "Coming Soon Home", "Screening Now Main", "Coming Soon Main"); // Replace with actual options.

        // Validate dropdown options
        boolean isValid = addMoviePage.validateDropdownOptions(expectedOptions);

        if (isValid) {
            System.out.println("Dropdown options validated successfully: " + expectedOptions);
        } else {
            System.out.println("Dropdown options validation failed. Expected: " + expectedOptions +
                    " | Actual: " + addMoviePage.getDropdownOptions());
        }

    }

    @Test(priority = 3)
    public void publishScreenNowHome(){
        System.out.println("----------------TC 003----------------\n");
        System.out.println("PUBLISH MOVIE TEST CASES : \n");

        addMoviePage.clickAddMovieBtn();


        //Search by Movie Title --> The Wild Robot
        addMoviePage.searchMovieTitle("The Green Mile");
        addMoviePage.clickSearchMovieBtn();

        //Publish Movie into Screen Now Home
        addMoviePage.clickDropdownMenu();
        addMoviePage.clickScreenNowHome();
        addMoviePage.clickPublishMovieBtn();

        sideBarTest.clickMovieManagement();

        String expectedPublishMovieTitle = "The Green Mile";
        String actualPublishMovieTitle = addMoviePage.movieTitle();

        String expectedMovieStatus = "Published (Screening Now Home)";
        String actualMovieStatus = addMoviePage.movieStatus();

        if (expectedPublishMovieTitle.equals(actualPublishMovieTitle)) {
            System.out.println("+ Publish Movie Successfully Show the Movie Management Page ");

            if(expectedMovieStatus.equals(actualMovieStatus)) {
                System.out.println("\t + " + actualMovieStatus + " Test Passed");
            }
            else{
                System.out.println("\t + " + actualMovieStatus + " Test Failed");
            }
        }
        else{
            System.out.println("+ Publish Movie Unsuccessfully Show the Movie Management Page ");
        }

    }









}
