package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddMoviePage {
    WebDriver driver;
    //Locators

    private By addMovieBtn = By.xpath("/html/body/div[1]/main/header/form/button");
    private By addMovieTitle = By.xpath("/html/body/header/h1");

    private By searchMovie = By.xpath("//*[@id=\"movie-title\"]");
    private By searchMovieButton = By.xpath("/html/body/main/div/form/div/button[1]");
    private By movieTitle01 = By.xpath("/html/body/main/div[2]/div/div[2]/p[1]");

    private By discardMovie = By.xpath("/html/body/main/div[1]/form/div/button[2]");

    //Movie details
    private By runtime = By.xpath("/html/body/main/div[2]/div/div[2]/div[1]/div[1]/p");
    private By imdb = By.xpath("/html/body/main/div[2]/div/div[2]/div[1]/div[5]/p");
    private By description = By.xpath("/html/body/main/div[2]/div/div[2]/p[2]");
    private By genres = By.xpath("/html/body/main/div[2]/div/div[2]/p[4]");

    //DropDown

    // Dropdown Menu Validation
    private By dropdownMenu = By.xpath("//*[@id=\"category\"]"); // Replace "dropdown-id" with the actual ID or locator of your dropdown menu.

    public List<String> getDropdownOptions() {
        Select dropdown = new Select(driver.findElement(dropdownMenu));
        List<WebElement> options = dropdown.getOptions();
        return options.stream().map(WebElement::getText).toList();
    }

    public boolean validateDropdownOptions(List<String> expectedOptions) {
        List<String> actualOptions = getDropdownOptions();
        return actualOptions.containsAll(expectedOptions) && actualOptions.size() == expectedOptions.size();
    }






    //Get the different types of movies


    public AddMoviePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddMovieBtn() {
        driver.findElement(addMovieBtn).click();
    }

    public String getAddMovieTitle() {
        return driver.findElement(addMovieTitle).getText();
    }


    //When add the movie title
    public void searchMovieTitle(String title ) {
        driver.findElement(searchMovie).sendKeys(title);
    }

    public void clickSearchMovieBtn() {
        driver.findElement(searchMovieButton).click();
    }

    public String getMovieTitle01() {
        return driver.findElement(movieTitle01).getText();
    }

    //Discard Movie Button
    public void clickDiscardMovie() {
        driver.findElement(discardMovie).click();
    }

    //Get the movie data

    public String getRuntime() {
       return driver.findElement(runtime).getText();
    }
    public String getImdb() {
        return driver.findElement(imdb).getText();
    }
    public String getDescription() {
       return  driver.findElement(description).getText();
    }
    public String getGenres() {
        return driver.findElement(genres).getText();
    }

    //Dropdown Menu Test







}
