package assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class FormValidation {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/sharma/Downloads/firefox/firefox");
        driver = new FirefoxDriver(options);

       driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void formvalidation(){
        try {
           WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
            firstNameField.sendKeys("Ankit");
            WebElement lastNameField = driver.findElement(By.name("lastname"));
            lastNameField.sendKeys("Sharma");
            WebElement malecheckbox = driver.findElement(By.id("sex-0"));
            if(!malecheckbox.isSelected()){
                malecheckbox.click();
            }
            WebElement experienceCheckbox = driver.findElement(By.id("exp-0"));
            experienceCheckbox.click();
            if (!experienceCheckbox.isSelected()){
                experienceCheckbox.click();
            }
            WebElement professionalCheck = driver.findElement(By.id("profession-0"));
            professionalCheck.click();
            professionalCheck.clear();
            WebElement professionalCheck2 = driver.findElement(By.id("profession-1"));
            professionalCheck2.click();
            if (!professionalCheck2.isSelected()){
                professionalCheck2.click();
            }
            WebElement dropdownElement = driver.findElement(By.id("controls"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Asia");
            WebElement datePicker = driver.findElement(By.id("datepicker"));
            datePicker.click();
            datePicker.sendKeys("29/10/2024");
            WebElement imageupload = driver.findElement(By.id("photo"));
            imageupload.click();
            WebElement clickhereto = driver.findElement(By.linkText("https://github.com/stanfy/behave-rest/blob/master/features/conf.yaml"));
            clickhereto.click();
            WebElement submitButton = driver.findElement(By.id("button"));
            submitButton.click();

        } catch(Exception e){
            Assert.fail("Form Validation Failed");
        }
    }

   @AfterMethod
    public void teardown(){
       if(driver != null){
            driver.quit();
             }
        }
    }
