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
import org.junit.*;
import static org.junit.Assert.*;

//new added
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

//import org.junit.experimental.categories.Category;
//import com.devops.capstone.IntegrationTest;

//@Category(IntegrationTest.class)
public class FunctionIT {

static WebDriver driver;

//    String driverPath = "//home//tanmesh//Downloads//geckodriver";
//    public WebDriver driver;

@BeforeClass
public static void setup() {
//driver = new FirefoxDriver();
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver=new ChromeDriver();

//	FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");
//        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(firefoxBinary);
        
//        driver = new FirefoxDriver(firefoxOptions);


//	System.setProperty("webdriver.gecko.driver", driverPath);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        driver = new FirefoxDriver(capabilities);

	Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver");
        System.setProperty("webdriver.gecko.driver",path.toString());
        driver = new FirefoxDriver();
}

@AfterClass
public static void cleanUp(){
driver.quit();
}

@Test
public void shouldSayHelloWorld(){
driver.get("https://www.google.com/");
assertEquals("Hello World!", driver.findElement(By.tagName("body")).getText());
}
}
