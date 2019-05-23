package Page;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Busqueda {

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
				

		String[] productos = { "PS4 infamous", "xbox one x", "Nintendo", "VideoJuegos" };
		int numRandon = (int) Math.round(Math.random() * 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-search")));
		WebElement TxtBuscar = driver.findElement(By.id("mobile-search"));
		TxtBuscar.sendKeys(productos[numRandon]); 
		WebElement BtnLupa = driver.findElement(By.xpath("//button[@class='btn btn-cta btn--search ']"));
		BtnLupa.click();
	}	
		
		public String obtenerPrecio() {
			
			
			List<WebElement> Lista = driver.findElements(By.xpath("//div[@id='productRow']/div"));
			Integer numero = (int) (Math.random() * Lista.size()) + 1;
			
			WebElement DivSeleccionar = driver.findElement(By.xpath("//*[@id='productRow']/div[" + numero + "]/a/div[2]"));
			DivSeleccionar.click();
			
			WebElement Precio = driver.findElement(By.className("product__price-block"));
			
			String[] PrecioDetalle = Precio.getText().split(" ");
			String PrecioFinal = PrecioDetalle[0]; 
			return PrecioFinal;
			
		}
		
		public void AgregarProdCarro() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='buy-action-button d-ib']")));
			WebElement BtnComprar = driver.findElement(By.xpath("//div[@class='buy-action-button d-ib']"));
			BtnComprar.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn--warning']")));
			WebElement IrAlCarro = driver.findElement(By.xpath("//button[@class='btn btn--warning']"));
			IrAlCarro.click();
			
			Thread.sleep(5000);			
		}
		
		public String obtenerPrecioCarro() {
			
			WebElement PrecioCarro = driver.findElement(By.xpath("//*[@id='WC_OrderItemDetailsf_td_3_']/span"));
			String PrecioCarroFinal = PrecioCarro.getText();			 
			return PrecioCarroFinal;			
		}
		
		
		public void validarValor(String precioDetalle, String precioCarro) {
			
			if (precioDetalle.equals(precioCarro)) {
				System.out.println("PrecioDetalle: "+ precioDetalle + " PrecioCarro: " + precioCarro);
				System.out.println("Son iguales los Precios");
			}else {
				System.out.println("PrecioDetalle: "+ precioDetalle + " PrecioCarro: " + precioCarro);
				System.out.println("No son iguales los precios");
				
			}			
		}
	
}
