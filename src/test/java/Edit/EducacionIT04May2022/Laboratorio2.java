package Edit.EducacionIT04May2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Laboratorio2 {
	
	String url = "http://automationpractice.com";
	String chromedriverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	
	
	@Test
	public void hacerBusquedaEnChrome() {
		//1- indicar donde esta el driver a utilizar
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		//2- acceder a la pagina que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		//3-escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//4-hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		//1- indicar donde esta el driver a utilizar
		System.setProperty("webdriver.gecko.driver", chromedriverPath);
		//2- acceder a la pagina que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		//3-escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//4-hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
