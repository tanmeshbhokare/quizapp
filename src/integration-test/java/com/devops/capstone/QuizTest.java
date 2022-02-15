package com.devops.capstone;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;
import com.devops.capstone.IntegrationTest;

@Category(IntegrationTest.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class QuizTest {

static WebDriver driver;
String baseUrl = "http://localhost:9090/quizapp/";

@BeforeClass
public static void setup() {
	Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver");
    System.setProperty("webdriver.gecko.driver",path.toString());
    driver = new FirefoxDriver();
}

@AfterClass
public static void cleanUp(){
driver.quit();
}

@Test
public void checkHomepageTitle() {
	driver.get(baseUrl);   
    assertTrue(driver.getTitle().contains("Login"));
}

@Test
public void loginSuccess() {
    WebElement username=driver.findElement(By.name("email"));
    WebElement password=driver.findElement(By.name("password"));
    WebElement login=driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            
    username.sendKeys("avinash.patel@wipro.com");
    password.sendKeys("1234");
    login.click();
    
    assertTrue(driver.getTitle().contains("Quiz Minds"));
}

@Test
public void quizSuccess() {

    System.out.println("Started Quiz 1");
    
    driver.get("http://localhost:9090/quizapp/success.jsp");

    driver.findElement(By.xpath("//button[contains(text(),'Quiz 1')]")).click();
    
    driver.findElement(By.id("d")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("a")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    WebElement text = driver.findElement(By.xpath("//h2[contains(text(),'You answered 5')]"));
    
    String score = text.getText();
    
    String expectedscore = "You answered 5/5 questions correctly";
    
    assertTrue(score.contentEquals(expectedscore));

    //Got to homepage
    driver.findElement(By.tagName("button")).click();
    System.out.println("Completed Quiz 1 and currently on Homepage");
    
    //Test Quiz 2
    System.out.println("Started Quiz 2");
    
    driver.findElement(By.xpath("//button[contains(text(),'Quiz 2')]")).click();
    
    driver.findElement(By.id("d")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("a")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("b")).click();
    driver.findElement(By.id("submit")).click();
    
    text = driver.findElement(By.xpath("//h2[contains(text(),'You answered 5')]"));
    
    score = text.getText();
    
    expectedscore = "You answered 5/5 questions correctly";
    
    assertTrue(score.contentEquals(expectedscore));
    
}

}