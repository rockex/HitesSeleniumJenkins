package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import Page.Busqueda;

public class Busqueda_producto extends Busqueda{
	public Busqueda_producto() {
		super();
	}
	
	@Test
	public void busquedaProducto() throws Exception{
		
		AbrirUrl();
		BuscarProducto();
		String precioDetalle = obtenerPrecio();// precio detalle del producto
		AgregarProdCarro();
		String precioCarro = obtenerPrecioCarro();// precio del producto en carro compra		
		validarValor(precioDetalle, precioCarro);//Valida Valores del Producto
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	
}
