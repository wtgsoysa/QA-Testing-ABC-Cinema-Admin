package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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
    private By screenNowHome = By.xpath("//*[@id=\"category\"]/option[1]");
    private By comingSoonHome = By.xpath("//*[@id=\"category\"]/option[2]");
    private By screenNowMain = By.xpath("//*[@id=\"category\"]/option[3]");
    private By comingSoonMain = By.xpath("//*[@id=\"category\"]/option[4]");

    private By publishMovieBtn = By.xpath("/html/body/main/div[3]/form/div/button");

    //Publish Movies Screening Now Home
    private By movieTitleSNH = By.xpath("/html/body/div[1]/main/div/div[15]/h3");
    private By movieStatusSNH = By.xpath("/html/body/div[1]/main/div/div[15]/p");

    //Publish Movies Coming Soon Home
    private By movieTitleCSH = By.xpath("/html/body/div[1]/main/div/div[16]/h3");
    private By movieStatusCSH = By.xpath("/html/body/div[1]/main/div/div[16]/p");

    //Publish Movies Screening Now Main
    private By movieTitleSNM = By.xpath("/html/body/div[1]/main/div/div[17]/h3");
    private By movieStatusSNM = By.xpath("/html/body/div[1]/main/div/div[17]/p");

    //Publish Movies Coming Soon Main
    private By movieTitleCSM = By.xpath("/html/body/div[1]/main/div/div[18]/h3");
    private By movieStatusCSM = By.xpath("/html/body/div[1]/main/div/div[18]/p");












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

    public List<String> getDropdownOptions() {
        Select dropdown = new Select(driver.findElement(dropdownMenu));
        List<WebElement> options = dropdown.getOptions();
        return options.stream().map(WebElement::getText).toList();
    }

    public boolean validateDropdownOptions(List<String> expectedOptions) {
        List<String> actualOptions = getDropdownOptions();
        return actualOptions.containsAll(expectedOptions) && actualOptions.size() == expectedOptions.size();
    }

    public List<String> selectCategories() {
        Select dropdown = new Select(driver.findElement(dropdownMenu));
        List<WebElement> options = dropdown.getOptions();
        return options.stream().map(WebElement::getText).toList();
    }

    public void clickDropdownMenu() {
        driver.findElement(dropdownMenu).click();
    }

    public void clickScreenNowHome() {

        driver.findElement(screenNowHome).click();

    }

    public void clickComingSoonHome() {

        driver.findElement(comingSoonHome).click();
    }

    public void clickComingSoonMain() {

        driver.findElement(comingSoonMain).click();
    }

    public void clickScreenNowMain() {

        driver.findElement(screenNowMain).click();
    }

    public void clickPublishMovieBtn() {
        driver.findElement(publishMovieBtn).click();
    }

    //Publish Movies Screening Now Home

    public String movieTitleSNH() {
        return driver.findElement(movieTitleSNH).getText();
    }

    public String movieStatusSNH() {
        return driver.findElement(movieStatusSNH).getText();
    }

    //Publish Movies Coming Soon Home

    public String movieTitleCSH() {
        return driver.findElement(movieTitleCSH).getText();
    }

    public String movieStatusCSH() {
        return driver.findElement(movieStatusCSH).getText();
    }

    //Publish Movies Screening Now Main

    public String movieTitleSNM() {
        return driver.findElement(movieTitleSNM).getText();
    }

    public String movieStatusSNM() {
        return driver.findElement(movieStatusSNM).getText();
    }

    //Publish Movies Coming Soon Main

    public String movieTitleCSM() {
        return driver.findElement(movieTitleCSM).getText();
    }

    public String movieStatusCSM() {
        return driver.findElement(movieStatusCSM).getText();
    }

    public void validateDropdownValues() {
        // Example: validate that the genres dropdown contains expected values
        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("your-dropdown-selector"));  // Use appropriate selector
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }
    }

    public List<String> getGenresList() {
        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("your-dropdown-selector")); // Use appropriate selector
        List<String> genres = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            genres.add(option.getText());
        }
        return genres;
    }









}
