package Entidad;

public class Contratacion {

	private int id_contratacion;
	private String nombre;
	private int id_seguro;
	private Double costo_contratacion;
	
	public Contratacion(int id_contratacion, String nombre, int id_seguro, Double costo_contratacion) {
		
		this.id_contratacion = id_contratacion;
		this.nombre = nombre;
		this.id_seguro = id_seguro;
		this.costo_contratacion = costo_contratacion;
	}

	public Contratacion() {
		
	}

	public int getId_contratacion() {
		return id_contratacion;
	}

	public void setId_contratacion(int id_contratacion) {
		this.id_contratacion = id_contratacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_seguro() {
		return id_seguro;
	}

	public void setId_seguro(int id_seguro) {
		this.id_seguro = id_seguro;
	}

	public Double getCosto_contratacion() {
		return costo_contratacion;
	}

	public void setCosto_contratacion(Double costo_contratacion) {
		this.costo_contratacion = costo_contratacion;
	}
	
	
	
}
