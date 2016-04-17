import static org.junit.Assert.*;

import java.awt.ItemSelectable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



@RunWith(Parameterized.class)
public class TestInfo {
	private String email = null;
	private String account = null;
	private static WebDriver driver;
	public TestInfo(String account,String email) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.email = email;
	}
	
	@BeforeClass
	public static void BeforeClass() throws IOException{
		String chDriver = new File(new File(".").getCanonicalPath() + "\\" +"driver/chromedriver.exe").getCanonicalPath();
		System.setProperty("webdriver.chrome.driver", chDriver);
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		
		//新建一个webdriver
		driver = new ChromeDriver();
	}
	
	@Parameters
	public static Collection<Object[]> getData() throws IOException {
		Object[][] obj = new Object[109][];
		
		BufferedReader reader = new BufferedReader(new FileReader("./file/info.csv"));
		String line = reader.readLine();
		int count = 0;
		try {
			while(line != null){
				String[] items = line.split(",");
				obj[count] = new Object[]{items[0],items[1]};
				count++;
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.asList(obj);
	}

	@Before
	public void Setup() throws IOException{
		driver.get("http://www.ncfxy.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		//获取账户
		WebElement account = driver.findElement(By.id("name"));
		account.clear();
		account.sendKeys(this.account);
		
		//获取密码
		WebElement password = driver.findElement(By.id("pwd"));
		password.clear();
		password.sendKeys(this.account.substring(4));
		
		//登录
		driver.findElement(By.id("submit")).click();
        
		assertEquals(this.email, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[1]/td[2]")).getText());
		assertEquals(this.account, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[2]/td[2]")).getText());
	}
	
	@After
	public void tearDown(){
		
	}
	
	@AfterClass
	public static void afterClass(){
		driver.close();
	}

}
