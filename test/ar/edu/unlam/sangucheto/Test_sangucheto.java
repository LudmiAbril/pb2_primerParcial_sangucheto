package ar.edu.unlam.sangucheto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Test_sangucheto {

	@Test
	public void darDeAltaUnIngrediente() {
		Ingrediente rodaja_pan = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(rodaja_pan);

		Integer deseado = 1;
		Integer obtenido = stock.getcantidadEnAlta();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void eliminarUnIngredienteQueNoEstaraDisponible() {
		Ingrediente rodaja_pan = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(rodaja_pan);
		stock.eliminarIngrediente(rodaja_pan);
		Integer deseado = 0;
		Integer obtenido = stock.getcantidadEnAlta();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void agregarStockDeUnIngredienteYVerificarQueLoTenga() {
		Ingrediente rodaja_pan = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(rodaja_pan);
		stock.agregarStock(rodaja_pan);

		Integer deseado = 1;
		Integer obtenido = stock.chequearStock(rodaja_pan);
		assertEquals(deseado, obtenido);
	}
	
	@Test
	public void calcularStockTotal() {
		Ingrediente i1 = new Ingrediente("pan", 100.0);
		Ingrediente i2 = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(i1);
		stock.darDeAlta(i2);
		stock.agregarStock(i1);
		stock.agregarStock(i2);

		Integer deseado = 2;
		Integer obtenido = stock.chequearStockTotal();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void eliminarStockDeUnIngrediente() {
		Ingrediente rodaja_pan = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(rodaja_pan);
		stock.agregarStock(rodaja_pan);
		stock.restarStock(rodaja_pan);

		Integer deseado = 0;
		Integer obtenido = stock.chequearStock(rodaja_pan);
		assertEquals(deseado, obtenido);
	}

	@Test
	public void ListarIngredientesDisponibles() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);

		ArrayList<Ingrediente> deseado = new ArrayList<Ingrediente>();
		deseado.add(ing1);
		deseado.add(ing2);
		ArrayList<Ingrediente> obtenido = stock.getIngredientesDisponibles();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void VerificarExistenciaDeUnIngrediente() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(ing1);

		assertTrue(stock.existeIngrediente(ing1));
	}

	@Test
	public void ComprarUnIngrediente() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(ing1);
		stock.comprar(ing1, 1);

		assertTrue(ing1.getCantExistencia() == 999);
		assertTrue(stock.chequearStock(ing1) == 1);

	}

	@Test
	public void armarUnSanguchetoConIngredientesDisponiblesDeStock() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Ingrediente ing3 = new Ingrediente("paty", 100.0);
		Ingrediente ing4 = new Ingrediente("mayonesa", 100.0);
		Stock stock = new Stock();

		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);
		stock.darDeAlta(ing3);
		stock.darDeAlta(ing4);

		stock.agregarStock(ing1);
		stock.agregarStock(ing2);
		stock.agregarStock(ing3);
		stock.agregarStock(ing4);

		Sangucheto sanguche = new Sangucheto();
		stock.agregarIngredienteAUnSangucheto(sanguche, ing1);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing2);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing3);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing4);

		Integer deseado = 4;
		Integer obtenido = sanguche.getCantIngredientes();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void queNoSePuedaArmarUnSanguchetoConIngredientesSinStock() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Ingrediente ing3 = new Ingrediente("paty", 100.0);
		Ingrediente ing4 = new Ingrediente("mayonesa", 100.0);
		Stock stock = new Stock();

		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);
		stock.darDeAlta(ing3);
		stock.darDeAlta(ing4);

		Sangucheto sanguche = new Sangucheto();
		stock.agregarIngredienteAUnSangucheto(sanguche, ing1);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing2);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing3);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing4);

		Integer deseado = 0;
		Integer obtenido = sanguche.getCantIngredientes();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void verPrecioDelSangucheto() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Ingrediente ing3 = new Ingrediente("paty", 100.0);
		Ingrediente ing4 = new Ingrediente("mayonesa", 100.0);
		Stock stock = new Stock();

		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);
		stock.darDeAlta(ing3);
		stock.darDeAlta(ing4);

		stock.agregarStock(ing1);
		stock.agregarStock(ing2);
		stock.agregarStock(ing3);
		stock.agregarStock(ing4);

		Sangucheto sanguche = new Sangucheto();
		stock.agregarIngredienteAUnSangucheto(sanguche, ing1);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing2);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing3);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing4);

		Double deseado = 400.0;
		Double obtenido = sanguche.getPrecioTotal();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void cancelarSangucheto() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Ingrediente ing3 = new Ingrediente("paty", 100.0);
		Ingrediente ing4 = new Ingrediente("mayonesa", 100.0);
		Stock stock = new Stock();

		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);
		stock.darDeAlta(ing3);
		stock.darDeAlta(ing4);

		stock.agregarStock(ing1);
		stock.agregarStock(ing2);
		stock.agregarStock(ing3);
		stock.agregarStock(ing4);

		Sangucheto sanguche = new Sangucheto();
		stock.agregarIngredienteAUnSangucheto(sanguche, ing1);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing2);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing3);
		stock.agregarIngredienteAUnSangucheto(sanguche, ing4);

		stock.cancelar(sanguche);
		Integer deseado = 0;
		Integer obtenido = sanguche.getCantIngredientes();
		assertEquals(deseado, obtenido);
	}

	@Test
	public void ListarIngredientesActualesDelSangucheto() {
		Ingrediente ing1 = new Ingrediente("pan", 100.0);
		Ingrediente ing2 = new Ingrediente("tomate", 100.0);
		Stock stock = new Stock();
		stock.darDeAlta(ing1);
		stock.darDeAlta(ing2);

		stock.agregarStock(ing1);
		stock.agregarStock(ing2);

		Sangucheto s = new Sangucheto();
		stock.agregarIngredienteAUnSangucheto(s, ing1);
		stock.agregarIngredienteAUnSangucheto(s, ing2);

		ArrayList<Ingrediente> deseado = new ArrayList<Ingrediente>();
		deseado.add(ing1);
		deseado.add(ing2);
		ArrayList<Ingrediente> obtenido = s.getIngredientes();
		assertEquals(deseado, obtenido);
	}
}
