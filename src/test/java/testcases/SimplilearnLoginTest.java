package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class SimplilearnLoginTest extends BaseClass{
	
	@Test	
	public void Test1() {
		
		test.log(LogStatus.INFO, "Test1 started");
		
		LoginPage lp = new LoginPage(driver);
		lp.Login("abc@xyz.com", "Abc@12345");
		
		WebElement error = driver.findElement(By.id("msg_box"));
		String acterror = error.getText();
		String experror = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(acterror, experror);
		Assert.assertTrue(error.isDisplayed());
		
	}
	
	@Test
	@Parameters({"uname", "pwd"})
	public void Test2(String Username, String Password) {
		
		test.log(LogStatus.INFO, "Test2 started");
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(Username, Password);
	}
	
	@Test
	public void Test3() {
		
		test.log(LogStatus.INFO, "Test3 started");
		
		String Username = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(Username, Password);
	}

}
