package assessment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropHandle {

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
        WebElement selectopt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dropdown")));
        selectopt.click();
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("1");
    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
