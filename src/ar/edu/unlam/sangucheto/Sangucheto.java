package ar.edu.unlam.sangucheto;

import java.util.ArrayList;

public class Sangucheto {
	ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();


	public void agregarIngrediente(Ingrediente ing) {
		ing.aumentarStock();
		ingredientes.add(ing);

	}

	public Integer getCantIngredientes() {
		return this.ingredientes.size();
	}

	public Double getPrecioTotal() {
		Double total=0.0;
		for(Ingrediente i : ingredientes) {
			total+=i.getPrecio();
		}
		return total;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void cancelar() {
		ingredientes.clear();
		
	}	
	

	
}
