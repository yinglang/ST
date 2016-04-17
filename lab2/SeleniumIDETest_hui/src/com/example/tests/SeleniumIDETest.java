package com.example.tests;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class SeleniumIDETest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.ncfxy.com";
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumIDE() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(name);
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys(name.substring(4));
    driver.findElement(By.id("submit")).click();
    assertTrue(email.equals(driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]")).getText()));
    //assertEquals(email, driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]")).getText());
  }
  
  @Parameters
  public static Collection<Object[]> getData() throws IOException{
      //使用参数化测试。每从csv文件中读取出一行创建一个object数组
      Object[][] obj = new Object[109][];
      CsvReader r= new CsvReader("E:\\课件\\大三下\\软件测试课件\\lab\\2\\info.csv",',',Charset.forName("GBK"));
      int count = 0;
      
      while(r.readRecord()){
          obj[count] = new Object[]{r.get(0), r.get(1)};
          count++;
      }
      return Arrays.asList(obj);
  }
  
  String name;
  String email;
  public SeleniumIDETest(String name, String email){
	  this.name = name;
	  this.email = email;
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
