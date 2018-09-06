package ReadingDataFromFile;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {

   	WebDriver driver;
    WebDriverWait wait; 
		
		@Test(priority=0)
		public void setUp()
		   {
		 	     System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		         driver = new ChromeDriver();
		         driver.get("http://automationpractice.com/index.php");
		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		         driver.manage().window().maximize();
		    }
	     @Test(priority=1)
		 public void CheckoutTest()
		    {
		
		    	wait = new WebDriverWait(driver, 10);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		        driver.findElement(By.id("email")).sendKeys("hf_challenge_123456@hf12345.com");
		        driver.findElement(By.id("passwd")).sendKeys("12345678");
		        driver.findElement(By.id("SubmitLogin")).click();
		    } 
		 
        @Test(priority=2)
		   public void GetDataFromExcel()
		   {      
	                Xls_Reader reader = new Xls_Reader("E:\\Test_Data.xlsx");
					int rowCount = reader.getRowCount("Sheet1");
									
        	  for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1");rowNum++) 
		       {
		    	   String DressName = reader.getCellData("Sheet1", "DressName", rowNum);
		    	   String Quantity = reader.getCellData("Sheet1", "Quantity", rowNum);
		    	   String Size = reader.getCellData("Sheet1", "Size", rowNum);
		    	   String Color = reader.getCellData("Sheet1", "Color", rowNum);
        	      
        	        if (DressName.equalsIgnoreCase("Faded Short Sleeve T-shirts"))
        	           {
        	        	Size = reader.getCellData("Sheet1", "Size", 5);
        	        	Quantity = reader.getCellData("Sheet1", "Quantity", 5);
        	        	
        	        	System.out.println("DressName is :" +DressName);
 				        System.out.println("Color is :" +Color);
 				        System.out.println("Quantity is :" +Quantity);
 				        System.out.println("Size is :" +Size);
				    
					    wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
				        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
				        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
				       
				        //Added code for Selection of Size, Color and Quantity of the Item/Dress
				        driver.findElement(By.id("quantity_wanted")).clear();
				        driver.findElement(By.id("quantity_wanted")).sendKeys(Quantity);
				        Select sizedropdown = new Select(driver.findElement(By.id("group_1")));
			            sizedropdown.selectByVisibleText(Size);
				        driver.findElement(By.id("color_14")).click();
				        
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
				        wait = new WebDriverWait(driver, 10);       
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
				        driver.findElement(By.name("processCarrier")).click();
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
				        wait = new WebDriverWait(driver, 10);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
				        driver.close();
		                }  
        	        
		       }
		   }
        
}

