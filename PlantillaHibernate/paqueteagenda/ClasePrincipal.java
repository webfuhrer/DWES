package paqueteagenda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class ClasePrincipal {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	public static void abrirConexion()
	{
	s=new StandardServiceRegistryBuilder().configure().build();
	sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Arranca main");
Libro l=new Libro("El Quijote", "Cervantes", 0);
try {
	abrirConexion();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save( l );
	
	session.getTransaction().commit();
	session.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	}
	
}
