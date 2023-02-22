package paquetebiblioteca;

public class Libro {
	private String titulo;
	private String genero;
	private int id;
	private int estado;
	public Libro(String titulo, String genero, int id, int estado) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.id = id;
		this.estado = estado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
