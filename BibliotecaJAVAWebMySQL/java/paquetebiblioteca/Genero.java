package paquetebiblioteca;

public class Genero {
private String genero;
private int id;
public Genero(String genero, int id) {
	super();
	this.genero = genero;
	this.id = id;
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

}
