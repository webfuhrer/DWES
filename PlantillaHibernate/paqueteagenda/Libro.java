package paqueteagenda;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabla_libros")
public class Libro {
private String titulo, genero;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

public Libro(String titulo, String genero, int id) {
	super();
	this.titulo = titulo;
	this.genero = genero;
	this.id = id;
}
public Libro() {

}

}
