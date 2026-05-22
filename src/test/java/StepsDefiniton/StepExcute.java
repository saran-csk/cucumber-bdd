package StepsDefiniton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.time.Duration;

public class StepExcute {
    WebDriver driver;
    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage(){
         driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//input[@id='user-name']")).clear();
//        driver.findElement(By.xpath("//input[@id='password']")).clear();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String string, String string2) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(string);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(string2);


    }

    @And("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        boolean verify = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
        Assert.assertEquals(verify,true);

    }

    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        boolean status= driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertEquals(status,true);
        driver.quit();

    }

}
