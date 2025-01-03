package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMoviePage {
    WebDriver driver;
    //Locators

    private By addMovieBtn = By.xpath("/html/body/div[1]/main/header/form/button");
    private By addMovieTitle = By.xpath("/html/body/header/h1");

    public AddMoviePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddMovieBtn() {
        driver.findElement(addMovieBtn).click();
    }

    public String getAddMovieTitle() {
        return driver.findElement(addMovieTitle).getText();
    }


}
