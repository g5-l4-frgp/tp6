package Entidad;

public class Tipo_seguro {
	
	private int id_tipo;
	private String descripcion;
	private int contador = 0;
	public Tipo_seguro(int id_tipo, String descripcion) {
		
		this.id_tipo = contador++;
		this.descripcion = descripcion;
	}
	
	public Tipo_seguro() {
		
	}

	public int getId() {
		return id_tipo;
	}

	public void setId(int id) {
		this.id_tipo = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
