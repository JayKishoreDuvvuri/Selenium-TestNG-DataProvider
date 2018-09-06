package ReadingDataFromFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingDataFromExcelDataProvider {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}    
    
      @AfterTest
      public void tearDown() {
	  driver.close();
     }
    
    
    @DataProvider
    public Iterator<Object[]> getTestData() { 
    	ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
    	return testdata.iterator();
    	
    }
    
    @Test(dataProvider="getTestData")
    public void datafromExcelTest(String Firstname, String Lastname, String Company,
    		String Address, String Address2, String City, String PostalCode, 
    	    String Other, String Homephone, 
    		String Mobilephone, String Alias, String Password, String Email) {
    
       wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
       driver.findElement(By.id("email_create")).sendKeys(Email);
       driver.findElement(By.id("SubmitCreate")).click();
       wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1"))).click();
       
     //  driver.findElement(By.id("customer_firstname")).clear();
       driver.findElement(By.id("customer_firstname")).sendKeys(Firstname);
       
    //   driver.findElement(By.id("customer_lasttname")).clear();
       driver.findElement(By.id("customer_lastname")).sendKeys(Lastname);
       
       driver.findElement(By.id("passwd")).clear();
       driver.findElement(By.id("passwd")).sendKeys(Password);
       
       Select select = new Select(driver.findElement(By.id("days")));
       select.selectByValue("1");
       select = new Select(driver.findElement(By.id("months")));
       select.selectByValue("7");
       select = new Select(driver.findElement(By.id("years")));
       select.selectByValue("1980");
       
   //    driver.findElement(By.id("company")).clear();
       driver.findElement(By.id("company")).sendKeys(Company);
       
   //    driver.findElement(By.id("address1")).clear();
       driver.findElement(By.id("address1")).sendKeys(Address);
       
   //    driver.findElement(By.id("address2")).clear();
       driver.findElement(By.id("address2")).sendKeys(Address2);
       
   //    driver.findElement(By.id("city")).clear();
       driver.findElement(By.id("city")).sendKeys(City);
       
       select = new Select(driver.findElement(By.id("id_state")));
       select.selectByVisibleText("Colorado");
       
  //     driver.findElement(By.id("postcode")).clear();
       driver.findElement(By.id("postcode")).sendKeys(PostalCode);
       
   //    driver.findElement(By.id("other")).clear();
       driver.findElement(By.id("other")).sendKeys(Other);
       
  //     driver.findElement(By.id("phone")).clear();
       driver.findElement(By.id("phone")).sendKeys(Homephone);
       
  //     driver.findElement(By.id("phone_mobile")).clear();
       driver.findElement(By.id("phone_mobile")).sendKeys(Mobilephone);
       
       driver.findElement(By.id("alias")).clear();
       driver.findElement(By.id("alias")).sendKeys(Alias);
       
    //   driver.findElement(By.id("submitAccount")).click();
       wait = new WebDriverWait(driver, 10);
       WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page-heading']")));
       
    }
        
}
		
		
		
		
		
	


