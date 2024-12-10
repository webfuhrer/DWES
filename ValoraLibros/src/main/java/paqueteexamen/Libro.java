package paqueteexamen;

import java.text.DecimalFormat;

public class Libro {
private String ISBN, nombre, autor, URL_portada, puntuaciones;



public Libro(String iSBN, String nombre, String autor, String uRL_portada, String puntuaciones) {
	super();
	ISBN = iSBN;
	this.nombre = nombre;
	this.autor = autor;
	URL_portada = uRL_portada;
	this.puntuaciones = puntuaciones;
}

public String getISBN() {
	return ISBN;
}

public String getNombre() {
	return nombre;
}

public String getAutor() {
	return autor;
}

public String getURL_portada() {
	return URL_portada;
}

public String getPuntuaciones() {
	return puntuaciones;
}

public String getAverage()
{
	//puntuaciones es algo así como 3-5-4-2-1-4
	//Lo spliteo (split)
	if (puntuaciones.length()<1)
	{
		return "Sin datos";
	}
	String [] notas=puntuaciones.split("-");
	float numero_votos=notas.length;
	float suma=0;
	for (int i=0; i<numero_votos; i++)
	{
		int voto=Integer.parseInt(notas[i]);
		suma=suma+voto;
	}
	
	float media=suma/numero_votos;
	media=round(media, 1);
	String texto=media+" ("+numero_votos+" votos)";
	return texto;
}

private static float round (float value, int precision) {
    int scale = (int) Math.pow(10, precision);
    return (float) Math.round(value * scale) / scale;
}
public String toCSV()
{
	/*String[] datos=linea.split(",");
				String nombre=datos[0];
				String autor=datos[1];
				String URL_portada=datos[2];
				String ISBN=datos[3];
				String puntuaciones=datos[4];*/
	String csv=nombre+","+autor+","+URL_portada+","+ISBN+","+puntuaciones+"\n";
	return csv;
}
}
