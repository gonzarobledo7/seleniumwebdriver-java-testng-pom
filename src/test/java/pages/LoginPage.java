package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Elmentos de la pagina
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement txtPass;
	
	@FindBy(name = "SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Sign out")
	WebElement linkSignOut;

	
	//Constructor de la pagina
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//ACCIONES sobre los elementos
	public void completeEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void completePass(String pass) {
		
		txtPass.sendKeys(pass);
	}
	
	public void hacerClickEnLogin() {
		
		btnLogin.click();
		
	}
	
public void hacerClickEnSignOut() {
		
		linkSignOut.click();
		
	}
	
	
	
}
