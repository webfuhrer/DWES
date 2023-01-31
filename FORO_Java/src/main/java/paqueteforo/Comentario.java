package paqueteforo;

import java.util.Calendar;

public class Comentario {
private String nombre;
private String comentario;
private String fecha;
public Comentario(String nombre, String comentario, String fecha) {
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
public String getFecha() {
	return fecha;
}
public String crearCSV()
{
	return nombre+","+comentario+","+fecha+"\n";
}
public static String recuperarFechaFormateada()
{
	Calendar obj_calendar=Calendar.getInstance();
	int dia_mes=obj_calendar.get(Calendar.DAY_OF_MONTH);
	int mes=obj_calendar.get(Calendar.MONTH)+1;
	int anyo=obj_calendar.get(Calendar.YEAR);
	int hour=obj_calendar.get(Calendar.HOUR_OF_DAY);
	int minutes=obj_calendar.get(Calendar.MINUTE);
	String minutos=(minutes<10)?"0"+minutes:String.valueOf(minutes);
	int seconds=obj_calendar.get(Calendar.SECOND);
	String segundos=(seconds<10)?"0"+seconds:String.valueOf(seconds);
	return dia_mes+"/"+mes+"/"+anyo+" "+hour+":"+minutos+":"+segundos;
}
public String crearHTML()
{
	String html="<br><b>"+nombre+"</b> dijo:" +comentario+"("+fecha+")<br>";
	return html;
}
}
