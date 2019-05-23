package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import Page.Comparacion;

public class Comparar_Producto extends Comparacion {
	public Comparar_Producto() {
		super();
	}
	
	
	@Test
	public void comparaProducto() throws Exception{
		
		AbrirUrl();
		BuscarProducto();		
		SeleccionarProductos();
		validarPagina();
		 
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
