package paquetenoticias;

public class Noticia {
private int id;
private String idioma, titular, cuerpo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIdioma() {
	return idioma;
}
public void setIdioma(String idioma) {
	this.idioma = idioma;
}
public String getTitular() {
	return titular;
}
public void setTitular(String titular) {
	this.titular = titular;
}
public String getCuerpo() {
	return cuerpo;
}
public void setCuerpo(String cuerpo) {
	this.cuerpo = cuerpo;
}
//Para construir objeto noticia desde la tabla
public Noticia(int id, String idioma, String titular, String cuerpo) {
	super();
	this.id = id;
	this.idioma = idioma;
	this.titular = titular;
	this.cuerpo = cuerpo;
}
//Para construir el objeto noticia cuando el usr lo inserta en insernoticia.jsp
public Noticia( String idioma, String titular, String cuerpo) {
	super();
	
	this.idioma = idioma;
	this.titular = titular;
	this.cuerpo = cuerpo;
}
public String toCSV()
{
	return id+","+idioma+","+titular+","+cuerpo+"\n";
}
}
