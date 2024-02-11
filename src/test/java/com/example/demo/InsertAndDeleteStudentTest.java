package com.example.demo;



// Generated by Selenium IDE

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertAndDeleteStudentTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/David/Desktop/DAVID/00.-FP/07.-DDI/00_SPRINGBOOT/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void insertAndDeleteStudentAceptanceXLTest() {
		// given
		driver.get("http://localhost:8081/");
		int width = 1916;
		int height = 969;
		driver.manage().window().setSize(new Dimension(width, height));

		// when
		driver.findElement(By.id("nombre")).sendKeys("pablo");
		driver.findElement(By.id("apellido")).sendKeys("gomez");
		driver.findElement(By.cssSelector("input:nth-child(6)")).click();

		// then
		assertEquals(driver.findElement(By.xpath("//td[contains(.,\'pablo\')]")).getText() , "pablo");
		assertEquals(driver.findElement(By.xpath("//td[contains(.,\'gomez\')]")).getText() , "gomez");
		driver.findElement(By.xpath("//a[@id=\'deleteBtn\']")).click();
	}

	@Test
	public void searchStudentAceptanceTest() {
	}

}
//package com.example.demo;
//
//// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//
//import java.util.HashMap;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Map;
//
//
//
//
//public class SegundotestInsertDeleteStudentTest {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @BeforeEach
//  public void setUp() {
//	System.setProperty("webdriver.chrome.driver", "C/Users/David/Desktop/DAVID/00.-FP/07.-DDI/00_SPRINGBOOT/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//	//driver = new ChromeDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();
//  }
//  @AfterEach
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void AceptancetestInsertDeleteStudent() {
//	
//	// given 
//    driver.get("http://localhost:8081/");
//    int width = 752;
//	int height = 816;
//	driver.manage().window().setSize(new Dimension(width, height));
//    
//	//when
//    driver.findElement(By.id("nombre")).click();
//    driver.findElement(By.id("nombre")).sendKeys("aaaa");
//    driver.findElement(By.id("apellido")).click();
//    driver.findElement(By.id("apellido")).sendKeys("asfdak");
//    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
//    {
//      WebElement element = driver.findElement(By.xpath("//tr[3]/td[2]"));
//      Actions builder = new Actions(driver);
//      builder.doubleClick(element).perform();
//    }
//    
//    //Then
//    assertThat(driver.findElement(By.xpath("//tr[3]/td[2]")).getText(), is("aaaa"));
//    {
//      WebElement element = driver.findElement(By.xpath("//tr[3]/td[3]"));
//      Actions builder = new Actions(driver);
//      builder.doubleClick(element).perform();
//    }
//    assertThat(driver.findElement(By.xpath("//tr[3]/td[3]")).getText(), is("asfdak"));
//    driver.findElement(By.xpath("(//a[contains(text(),\'Delete\')])[3]")).click();
//  }
//}
