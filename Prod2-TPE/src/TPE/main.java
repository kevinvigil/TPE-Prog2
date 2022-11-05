//a) Se cree la lista de n�meros mostrada en la figura del punto 2, con los valores
//insertados en el siguiente orden: 10, 21, 1, 5, 11
//b) Se recorra la lista creada (utilizando un foreach) y se impriman los valores por consola
//c) Se elimine el primer elemento de la lista (por posici�n), luego el elemento �5� y luego
//el elemento �11� (dado el elemento). Volver a recorrer e imprimir la lista resultante.
//d) Se cree la lista de strings mostrada en la figura 2 del punto 1, con los valores
//insertados en el siguiente orden: �F�cil�, �Es�, �Parcial�, �Prog 2�.
//e) Se recorra la lista creada y se impriman los valores por consola
//f) Imprimir por consola en qu� posici�n se encuentra la palabra �Parcial�.
//g) Imprimir por consola en qu� posici�n se encuentra la palabra �Recuperatorio�
//h) Se cambie el orden de la lista de strings para que los elementos queden ordenados descendentemente.
//i) Implementar las siguientes dos estructuras e ins�rtelas en una lista vinculada
//ordenadas por cantidad total de alumnos (de mayor a menor)



package TPE;


import TPE.Comparadores.ComparadorPorApellido;
import TPE.Comparadores.ComparadorPorNombre;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		
		// System.out.println("Test Iterador...\n"); 
		// try {
		// 	ListaVinculada listaNumeros = new ListaVinculada();
			
		// 	int uno = 1;
		// 	int cinco = 5;
		// 	int diez = 10;
		// 	int once = 11;
		// 	int veintiUno = 21;
			
		// 	listaNumeros.addDato(diez);
		// 	listaNumeros.addDato(veintiUno);
		// 	listaNumeros.addDato(uno);					//incompleto
		// 	listaNumeros.addDato(cinco);
		// 	listaNumeros.addDato(once);
			
		// 	ListaVinculada lista = new ListaVinculada();
		
		// 	String a ="Es";
		// 	String b ="Facil";
		// 	String c ="Parcial";
		// 	String d = "Prog 2";
		// 	lista.addDato(b);
		// 	lista.addDato(a);
		// 	lista.addDato(c);
		// 	lista.addDato(d);
			
		// 	Iterator<Nodo> it = lista.iterator();
			
		// 	while(it.hasNext()) {
		// 		System.out.println(it.next().getValor());
		// 	}
		// }
		// catch(Exception ex) {
		// 	System.out.println("Fallo Test!! \n Error: "+ ex.getMessage()); 
		// }
		
		// System.out.println("\nTest Alumnos...\n"); 
		
		try {
			ListaVinculada listaAlumnos = new ListaVinculada();
			Iterator<Nodo> itAlumno = listaAlumnos.iterator();
			listaAlumnos.setComparator(new ComparadorPorNombre());
			Alumno j = new Alumno("Albano", "Rodriguez", 38270192, 19);
			listaAlumnos.addDato(new Alumno("Camila", "Abarez", 38270192, 19));
			listaAlumnos.addDato(new Alumno("Rocio", "Tito", 38270192, 19));
			listaAlumnos.addDato(new Alumno("Albano", "Rodriguez", 38270192, 19));
			ComparadorPorApellido t = new ComparadorPorApellido();
			
			// for (Nodo nodo : listaAlumnos) {
			// 	System.out.println("Alumnos ="+ nodo);
			// }

			while(itAlumno.hasNext()) {
				System.out.println(((Alumno)itAlumno.next().getValor()).getNombre());
			}
		}
		catch(Exception ex) {
			System.out.println("Fallo Test!! \nError: "+ ex); 
		}
		
	}

}
