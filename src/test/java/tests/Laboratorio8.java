package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.DatosExcel;
import pages.HomePage;
import pages.LoginPage;

public class Laboratorio8 {

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
	
	//para enlazar metodo con @Test le pasamos el name del data provider como parametro
	@Test(dataProvider="Obtener Datos Excel del Login")
	public void login(String email, String password) {
		//paso 1- hacer click en SignIn
		HomePage inicio = new HomePage(driver);
		inicio.makeClickOnSighIn();
		
		//Passo 2- ingresar credenciales
		LoginPage login = new LoginPage(driver);
		login.completeEmail(email);
		login.completePass(password);
		
		//Paso 3- Hacer click en el boton
		login.hacerClickEnLogin();
		
		//Comprobacion de si el usuario pudo iniciar sesion, para eso podemos hacer un Assert
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
		//si el user puydo iniciar sesion, cerramos la pagina para dejar la prueba en el punto iniicial
		login.hacerClickEnSignOut();
				
		
		
	}
	//Lista de datos, este metodo construye una lista de 3 filas y dos columnas y lo devuelve
	
//	@DataProvider(name="Datos del Login")
//	public Object [][] getData(){
//		
//		Object[][] datos = new Object[3][2];
//		
//		//Completar las combinaciones de datos para probar el login
//		datos[0][0] = "avbc@correo.com";
//		datos [0][1] = "123c";
//		
//		datos[1][0] = "afsdfsd@correo.com";
//		datos [1][1] = "12322c";
//		
//		datos[2][0] = "aasdasc@correo.com";
//		datos [2][1] = "123zxsc";
//		
//		
//		return datos;
//	}
	
	@DataProvider(name="Obtener Datos Excel del Login")
	public Object [][] getDataFromExcel() throws Exception{
		
		return DatosExcel.leerExcel("..\\EducacionIT04May2022\\Datos\\DataExcel.xlsx", "Hoja1");
	}
	
}
