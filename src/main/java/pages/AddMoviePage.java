package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMoviePage {
    WebDriver driver;
    //Locators

    private By addMovieBtn = By.xpath("/html/body/div[1]/main/header/form/button");
    private By addMovieTitle = By.xpath("/html/body/header/h1");

    private By searchMovie = By.xpath("//*[@id=\"movie-title\"]");
    private By searchMovieButton = By.xpath("/html/body/main/div/form/div/button[1]");
    private By movieTitle01 = By.xpath("/html/body/main/div[2]/div/div[2]/p[1]");


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
    public void searchMovieTitle(String title) {
        driver.findElement(searchMovie).sendKeys(title);
    }

    public void clickSearchMovieBtn() {
        driver.findElement(searchMovieButton).click();
    }

    public String getMovieTitle01() {
        return driver.findElement(movieTitle01).getText();
    }


}
