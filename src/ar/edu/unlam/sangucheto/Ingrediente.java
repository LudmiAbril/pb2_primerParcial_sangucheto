package ar.edu.unlam.sangucheto;

public class Ingrediente {
	private String nombre;
	private Integer cantidad;
	private Double precio;
	private Integer cant_existencia;

	public Ingrediente(String nombre, Double precio) {
		this.nombre = nombre;
		this.cantidad = 0;
		this.precio = precio;
		this.cant_existencia = 1000;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void aumentarStock() {
		this.cantidad++;
	}

	public void restarStock() {
		this.cantidad = this.cantidad - 1;
	}

	public Double getPrecio() {
		return precio;
	}

	public Integer getCantExistencia() {
		return this.cant_existencia;
	}

	public void restarCantExistencia(Integer cant) {
		this.cant_existencia = this.cant_existencia - cant;
	}

}
