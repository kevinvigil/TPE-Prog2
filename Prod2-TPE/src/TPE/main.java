package TPE;


import TPE.Comparadores.ComparadorPorNombre;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Test Iterador...\n"); 
		try {
			ListaVinculada lista = new ListaVinculada();
		
			String a ="Albano";
			String b ="Bautista";
			String c ="Camila";
			lista.addDato(b);
			lista.addDato(c);
			lista.addDato(a);
			
			Iterator<Nodo> it = lista.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next().getValor());
			}
		}
		catch(Exception ex) {
			System.out.println("Fallo Test!! \n Error: "+ ex.getMessage()); 
		}
		
		System.out.println("\nTest Alumnos...\n"); 
		
		try {
			ListaVinculada listaAlumnos = new ListaVinculada();
			Iterator<Nodo> itAlumno = listaAlumnos.iterator();
			listaAlumnos.setComparator(new ComparadorPorNombre());
			listaAlumnos.addDato(new Alumno("Camila", "Rodriguez", 38270192, 19));
			listaAlumnos.addDato(new Alumno("Rocio", "Rodriguez", 38270192, 19));
			listaAlumnos.addDato(new Alumno("Albano", "Rodriguez", 38270192, 19));
			
			while(itAlumno.hasNext()) {
				System.out.println(((Alumno)itAlumno.next().getValor()).getNombre());
			}
		}
		catch(Exception ex) {
			System.out.println("Fallo Test!! \nError: "+ ex); 
		}
		
	}

}
