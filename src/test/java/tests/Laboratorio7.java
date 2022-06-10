package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class Laboratorio7 {
	
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";

	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		//paso 1- hacer click en SignIn
		HomePage inicio = new HomePage(driver);
		inicio.makeClickOnSighIn();
		
		//Passo 2- ingresar credenciales
		LoginPage login = new LoginPage(driver);
		login.completeEmail("correo01@gmail.com");
		login.completePass("12312312");
		login.hacerClickEnLogin();
		//Paso 3- Hacer click en el boton
		
	}
	
	
}
