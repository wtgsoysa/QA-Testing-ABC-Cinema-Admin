package TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ABC_Cinema_Admin {
    public static void main(String[] args) {

        WebDriver driver ;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/ABC_Cinema_Admin_Web_exploded/");
    }
}
    /*---------------------------- TEST CASE SECTION ------------------------------------*/

