package ar.edu.unlam.sangucheto;

import java.util.ArrayList;
import java.util.Iterator;

public class Stock {
	ArrayList<Ingrediente> stock = new ArrayList<Ingrediente>();

	public void darDeAlta(Ingrediente ingr) {
		stock.add(ingr);
	}

	public Integer getcantidadEnAlta() {
		return stock.size();
	}

	public void agregarStock(Ingrediente ingr) {
		Iterator<Ingrediente> itr = this.stock.iterator();

		while (itr.hasNext()) {
			Ingrediente i = itr.next();
			if (i.equals(ingr)) {
				i.aumentarStock();
			}
		}
	}

	public Integer chequearStock(Ingrediente ingr) {
		Iterator<Ingrediente> itr = this.stock.iterator();

		while (itr.hasNext()) {
			Ingrediente i = itr.next();
			if (i.equals(ingr)) {
				return i.getCantidad();
			}
		}
		return 0;
	}

	public ArrayList<Ingrediente> getIngredientesDisponibles() {
		return this.stock;
	}

	public boolean existeIngrediente(Ingrediente ing) {
		return stock.contains(ing);
	}

	public void agregarIngredienteAUnSangucheto(Sangucheto sanguche, Ingrediente ing) {
		if (chequearStock(ing) > 0) {
			restarStock(ing);
			sanguche.agregarIngrediente(ing);
		}

	}

	public void restarStock(Ingrediente ing) {
		for (Ingrediente i : stock) {
			if (i.equals(ing)) {
				i.restarStock();
			}
		}

	}

	public void cancelar(Sangucheto sanguche) {
		Iterator<Ingrediente> itrs = this.stock.iterator();
		while (itrs.hasNext()) {

			Ingrediente i_s = itrs.next();

			Iterator<Ingrediente> itr = this.stock.iterator();
			while (itr.hasNext()) {
				Ingrediente i = itr.next();
				if (i.equals(i_s)) {
					i.aumentarStock();
				}
			}

		}
		sanguche.cancelar();
	}

	public void comprar(Ingrediente ing, Integer cant) {
		ing.restarCantExistencia(cant);
		this.agregarStock(ing);
		
	}

	public void eliminarIngrediente(Ingrediente ing) {
		this.stock.remove(ing);
		
	}

	public Integer chequearStockTotal() {
		Integer total=0;
		for(Ingrediente i : stock) {
			total+=i.getCantidad();
		}
		return total;
	}

}
