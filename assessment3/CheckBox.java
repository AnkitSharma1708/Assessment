package assessment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/sharma/Downloads/firefox/firefox");
        driver = new FirefoxDriver(options);

        driver.get("https://the-internet.herokuapp.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void main(){
        WebElement checkboxopt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkboxes")));
        checkboxopt.click();
        WebElement checkbox = driver.findElement(By.id("checkboxes"));

        if (!checkbox.isSelected()){
            checkbox.click();
        }

        if (checkbox.isSelected()){
            System.out.println("CheckBox is Selected");
        }else {
            System.out.println("Check is not Selected");
        }

        checkbox.click();
    }

    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
}
