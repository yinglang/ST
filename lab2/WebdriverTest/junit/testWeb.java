import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class testWeb {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	//private List<String> dataList;
	//private int i = 0;
	
	//@BeforeClass
	//public void loadCsv(){
		//File file = new File("C:/MyFiles/info.csv");
		//dataList = importCsv(file);
	//}
	
	//private String nextData(){
		//if (i >= dataList.size()){
	//		return null;
	//	}
	//	else{
	//		return dataList.get(i++);
	//	}
	//}
	
	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.ncfxy.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testEmail() {
		File file = new File("C:/MyFiles/info.csv");
		List<String> data = importCsv(file);
		String number = "";
		String email = "";
		
		for (int i = 0; i < data.size(); i++){
			int d = data.get(i).indexOf(',');
			number = data.get(i).substring(0, d);
			email = data.get(i).substring(d + 1);
			
			if (number.equals("")){
				continue;
			}
			 
			inputMessage(number, email);
			
			assertEquals(email, driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]")).getText());
		    assertEquals(number, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[2]/td[2]")).getText());
		}
	}

	@After
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	//µ¼Èëcsv
	public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
	
	private void inputMessage(String number, String email){
		//driver.manage().window().maximize();
		driver.get(baseUrl + "/");
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(number);
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys(number.substring(4));
	    //System.out.println(number);
	    //System.out.println(email);
	    driver.findElement(By.id("submit")).click();
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
