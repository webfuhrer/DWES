package paqueteagenda;

public class Contacto {
private String nombre;
private String telefono;
//Opcion 1: setters
//Opcion 2: Constructor con parámetros
public Contacto(String nombre, String telefono) {
	super();
	this.nombre = nombre;
	this.telefono = telefono;
}
public String getNombre() {
	return nombre;
}
public String getTelefono() {
	return telefono;
}
@Override
public String toString() {
	return "NOMBRE:" + nombre + "TELEFONO:" + telefono + "]";
}


}
