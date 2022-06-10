package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Sign in")
	WebElement linkSignIn;		//Representa el hipervinculo de la pagina
	
	//Definir el constructor de la pagina, para que desde cualqyuier otra clase JAVA cuando haya un @Test se pueda utilizar 
	//esto y pueda solamente invocar al metodo y automatizamente sabe que se refiere a el elemento.
	
	public HomePage(WebDriver driver) {//dentro del constructor vamos a invocar al init element, que es un analizador para ver si los elementos existen al momento de la corrida
		PageFactory.initElements(driver, this);//el parametro es el navegador, y cuales son los elementos, los que esten en esta clase
		
	}
	
	
	//Metodo que representa la ACCION que se puede hacer con el elemento de la pagina
	public void makeClickOnSighIn() {
		
		linkSignIn.click();
	}
	
}
