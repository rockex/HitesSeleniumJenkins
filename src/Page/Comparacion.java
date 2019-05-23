package Page;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Comparacion {
	
	
public WebDriver driver;
	
	public void AbrirUrl() throws IOException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String url = "https://www.hites.com";
		driver.get(url);			
	}

	
	public void BuscarProducto() throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);	
			WebElement anuncio;
				try {
					Thread.sleep(15000);
					anuncio = driver.findElement(By.id("onesignal-popover-cancel-button"));
					anuncio.click();
					Thread.sleep(1000);
		
				} catch (NoSuchElementException e) {
		
				}
						
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-search")));
			WebElement TxtBuscar = driver.findElement(By.id("mobile-search"));
			TxtBuscar.sendKeys("Nintendo"); 
			WebElement BtnLupa = driver.findElement(By.xpath("//button[@class='btn btn-cta btn--search ']"));
			BtnLupa.click();
		}	

	
	public void SeleccionarProductos() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='productRow']/div[" + 1 + "]/a/div[3]")));
										
		WebElement BotonComparar1 = driver.findElement(By.xpath("//*[@id='productRow']/div[" + 1 + "]/a/div[3]"));
		BotonComparar1.click();
				
		WebElement BotonComparar2 = driver.findElement(By.xpath("//*[@id='productRow']/div[" + 2 + "]/a/div[3]"));
		BotonComparar2.click();		 
		
		WebElement BtnCompararProd = driver.findElement(By.xpath("//*[@id='main']/button"));        
		BtnCompararProd.click();

	}
	
	
	
	public void validarPagina() {
		
		
		WebElement TituloPagina = driver.findElement(By.xpath("//*[@id='react-app']/section/div/div/div[1]/h1"));
		String TituloFinal = TituloPagina.getText().trim();
				
		if (TituloFinal.equals("COMPARAR PRODUCTOS")) {			
			System.out.println("La Pagina Reedirigida es Correcta");
		}else {			
			System.out.println("La Pagina Reedirigida es Incorrecta");			
		}			
	}
	
}
