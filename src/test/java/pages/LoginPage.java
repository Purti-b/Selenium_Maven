package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//***************************************Object****************************************
	
	WebDriver driver;
	
	@FindBy(linkText = "Log in")      //initialized
	WebElement loginlink;
	
	@FindBy(name = "user_login")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(className = "rememberMe")
	WebElement remember;
	
	@FindBy(name = "btn_login")
	WebElement loginbutton;
	
	public LoginPage(WebDriver basedriver) {
		this.driver = basedriver;
		
		//it will initialize all the FindBy elements on basedriver (the way we use driver.findElement) whenever this element will be needed (all elements present on this page)
		PageFactory.initElements(basedriver, this);  
	}
	
//**************************************Method****************************************
	
	public void Login(String UsernameVal, String PassVal) {

		loginlink.click();
		
		username.sendKeys(UsernameVal);
		
		password.sendKeys(PassVal);
		
		remember.click();
		
		loginbutton.click();
	}
}
