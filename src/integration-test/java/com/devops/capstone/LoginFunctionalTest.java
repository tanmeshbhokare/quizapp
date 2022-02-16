package com.devops.capstone;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;
import com.devops.capstone.IntegrationTest;

@Category(IntegrationTest.class)
public class LoginFunctionalTest {

static WebDriver driver;

@BeforeClass
public static void setup() {
    Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver");
    System.setProperty("webdriver.gecko.driver",path.toString());
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);
    driver = new FirefoxDriver(options);
}

@AfterClass
public static void cleanUp(){
driver.quit();
}

@Test
public void loginSuccess() {
        driver.get("http://localhost:9090/quizapp");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("avinash.patel@wipro.com");
        pass.sendKeys("1234");
        button.click();
        assertTrue(driver.getTitle().contains("Quiz Minds"));
}
	
@Test
public void loginFail() {
        driver.get("http://localhost:9090/quizapp");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("tanmesh@wipro.com");
        pass.sendKeys("1234566666");
        button.click();
        assertTrue(driver.getPageSource().contains("Invalid username or password, Please try again with valid"));
}
	
@Test
public void registrationSuccess() {
        driver.get("http://localhost:9090/quizapp/register.jsp");
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement confirmpass = driver.findElement(By.name("confirmpass"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        firstname.sendKeys("fname");
        lastname.sendKeys("lname");
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("aa@gmail.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Quiz Minds"));
}
	
@Test
public void forgotPasswordSuccess() {
        driver.get("http://localhost:9090/quizapp/forgotpassword.jsp");      
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("avinash.patel@wipro.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Quiz Minds"));
}
}
