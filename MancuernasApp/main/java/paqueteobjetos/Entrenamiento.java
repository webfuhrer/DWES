package paqueteobjetos;

public class Entrenamiento {
private int id;
private String usuario;
private String fecha;
private String[] ejercicios;
private String[] observaciones;

public Entrenamiento(int id, String usuario, String fecha, String[] ejercicios, String[] observaciones) {
	super();
	this.id = id;
	this.usuario = usuario;
	this.fecha = fecha;
	this.ejercicios = ejercicios;
	this.observaciones = observaciones;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String[] getEjercicios() {
	return ejercicios;
}
public void setEjercicios(String[] ejercicios) {
	this.ejercicios = ejercicios;
}
public String[] getObservaciones() {
	return observaciones;
}
public void setObservaciones(String[] observaciones) {
	this.observaciones = observaciones;
}

public String toCSV()
{
	String csv=fecha+",";
	for (int i=0; i<4; i++)
	{
		csv+=ejercicios[i]+","+observaciones[i]+",";
	}
	csv=csv.substring(0, csv.length()-1);
	csv+="\n";
	return csv;
}

}
