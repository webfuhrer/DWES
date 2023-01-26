package paqueteforo;

import java.util.Calendar;

public class Comentario {
private String nombre;
private String comentario;
private Calendar fecha;
public Comentario(String nombre, String comentario, Calendar fecha) {
	super();
	this.nombre = nombre;
	this.comentario = comentario;
	this.fecha = fecha;
}
public String getNombre() {
	return nombre;
}
public String getComentario() {
	return comentario;
}
public Calendar getFecha() {
	return fecha;
}
public String crearCSV()
{
	return nombre+","+comentario+","+fecha+"\n";
}
public String crearHTML()
{
	String html="<br><b>"+nombre+"</b> dijo:" +comentario+"("+fecha+")<br>";
	return html;
}
}
