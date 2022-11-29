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

import TPE.Comparadores.compAlumnosYGrupos.ComparadorPorCantidad;
import TPE.Comparadores.compAlumnosYGrupos.ComparadorPorNombre;
import TPE.Comparadores.compLogicos.ComparadorNot;
import TPE.Comparadores.compOfType.ComparadorInteger;
import TPE.Comparadores.compOfType.ComparadorString;

import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Test Iterador...\n"); 
		try {
			ComparadorInteger l = new ComparadorInteger();
			ListaVinculada listaNumeros = new ListaVinculada(l);

			//a) Se cree la lista de n�meros mostrada en la figura del punto 2, con los valores
			//insertados en el siguiente orden: 10, 21, 1, 5, 11
			Integer uno = 1;
			Integer cinco = 5;
			Integer diez = 10;
			Integer once = 11;
			Integer veintiUno = 21;
			
			listaNumeros.addDato(diez);
			listaNumeros.addDato(veintiUno);
			listaNumeros.addDato(uno);					
			listaNumeros.addDato(cinco);
			listaNumeros.addDato(once);

			//b) Se recorra la lista creada (utilizando un foreach) y se impriman los valores por consola

			for (Nodo nodo : listaNumeros) {
				System.out.println("numero = "+ nodo);
			}

			//c) Se elimine el primer elemento de la lista (por posici�n), luego el elemento �5� y luego
			//el elemento �11� (dado el elemento). Volver a recorrer e imprimir la lista resultante.

			listaNumeros.deleteDato(1);
			listaNumeros.deleteOcurrencias(cinco);
			listaNumeros.deleteOcurrencias(once);
			System.out.println("Luego de borrar...\n"); 
			
			for (Nodo nodo : listaNumeros) {
				System.out.println("numero = "+ nodo);
			}
			
			//d) Se cree la lista de strings mostrada en la figura 2 del punto 1, con los valores
			//insertados en el siguiente orden: �F�cil�, �Es�, �Parcial�, �Prog 2�.

			ComparadorString compString = new ComparadorString();
			ListaVinculada listaString = new ListaVinculada(compString);
		
			String a ="Es";
			String b ="Facil";
			String c ="Parcial";
			String d = "Prog 2";
			listaString.addDato(b);
			listaString.addDato(a);
			listaString.addDato(c);
			listaString.addDato(d);

			//e) Se recorra la lista creada y se impriman los valores por consola

			for (Nodo nodo : listaString) {
				System.out.println("String = "+ nodo);
			}

			//f) Imprimir por consola en qu� posici�n se encuentra la palabra �Parcial�.
			
			System.out.println("Parcial = "+listaString.posElemento("Parcial"));

			//g) Imprimir por consola en qu� posici�n se encuentra la palabra �Recuperatorio�

			System.out.println("Recuperatorio = "+listaString.posElemento("Recuperatorio"));

			//h) Se cambie el orden de la lista de strings para que los elementos queden ordenados descendentemente.

			ComparadorNot not = new ComparadorNot(compString);
			listaString.setComparator(not);
			listaString.order();

			for (Nodo nodo : listaString) {
				System.out.println("String = "+ nodo);
			}
		}
		catch(Exception ex) {
			System.out.println("Fallo Test!! \n Error: "+ ex.getMessage()); 
		}
		
		// System.out.println("\nTest Alumnos...\n"); 
		
		// try {
		// 	ListaVinculada listaAlumnos = new ListaVinculada(new ComparadorPorNombre());
		// 	Iterator<Nodo> itAlumno = listaAlumnos.iterator();
		// 	listaAlumnos.addDato(new Alumno("Camila", "Abarez", 38270192, 19));
		// 	listaAlumnos.addDato(new Alumno("Rocio", "Tito", 38270192, 19));
		// 	listaAlumnos.addDato(new Alumno("Albano", "Rodriguez", 38270192, 19));
			
		// 	// for (Nodo nodo : listaAlumnos) {
		// 	// 	System.out.println("Alumnos ="+ nodo);
		// 	// }

		// 	while(itAlumno.hasNext()) {
		// 		System.out.println(((Alumno)itAlumno.next().getValor()).getNombre());
		// 	}
		// }
		// catch(Exception ex) {
		// 	System.out.println("Fallo Test!! \nError: "+ ex); 
		// }

		// try {
		// 	//i) Implementar las siguientes dos estructuras e ins�rtelas en una lista vinculada
		// 	//ordenadas por cantidad total de alumnos (de mayor a menor)

		// 	System.out.println("\nTest Unicen...\n"); 
			
		// 	ComparadorPorCantidad compCant = new ComparadorPorCantidad();
		// 	Grupo unicen = new Grupo("unicen", compCant);
		// 		Alumno John = new Alumno("John", "Doe", 35999888, 21);
		// 			John.addPalabras("intercambio");
		// 		Grupo exactas = new Grupo("exactas", compCant);
		// 			Alumno Federico = new Alumno("Federico", "Lopez", 35999888, 22);
		// 				Federico.addPalabras("redes");
		// 				Federico.addPalabras("php");
		// 				Federico.addPalabras("java");
		// 				Federico.addPalabras("Pyton");
		// 			Alumno Juana = new Alumno("Juana", "Garcia", 27123455, 18);
		// 				Juana.addPalabras("programacion");
		// 				Juana.addPalabras("php");
		// 				Juana.addPalabras("java");
		// 		Grupo humanas = new Grupo("humanas", compCant);
		// 			Alumno Mora = new Alumno("Mora", "Diaz", 37124425, 25);
		// 				Mora.addPalabras("psicologia");
		// 				Mora.addPalabras("Freud");
		// 			Grupo historia = new Grupo("historia", compCant);
		// 				Alumno Flora = new Alumno("Flora", "Rivas", 34555111, 18);
		// 					Flora.addPalabras("historia");
		// 					Flora.addPalabras("antigua");
		// 				Alumno Martin = new Alumno("Martin", "Gomez", 34111222, 19);
		// 					Martin.addPalabras("romanos");
		// 					Martin.addPalabras("egipcio");
		// 					Martin.addPalabras("griegos");
		// 				Alumno Roman = new Alumno("Roman", "Bazan", 32555111, 27);
		// 					Roman.addPalabras("argentina");
							
		// 	historia.AddElemento(Flora);
		// 	historia.AddElemento(Martin);
		// 	historia.AddElemento(Roman);

		// 	humanas.AddElemento(Mora);
		// 	humanas.AddElemento(historia);

		// 	exactas.AddElemento(Federico);
		// 	exactas.AddElemento(Juana);

		// 	unicen.AddElemento(John);
		// 	unicen.AddElemento(exactas);
		// 	unicen.AddElemento(humanas);
			
			
		// 	System.out.println("\nImprimiendo...\n"); 
		// 	unicen.Print();
			
			
		// 	Grupo OlimpiadasMatematicas = new Grupo ("OlimpiadasMatematicas", compCant);
			
		// 		Grupo Mateados = new Grupo ("Mateados", compCant);
		// 			Alumno Juan = new Alumno ("Juan", "Juarez", 33222444, 24);
		// 				Juan.addPalabras("sucesiones");
		// 				Juan.addPalabras("algebra");
		// 			Alumno Julio = new Alumno ("Julio", "Cesar", 33222111, 28);
		// 				Julio.addPalabras("sucesiones");
		// 				Julio.addPalabras("algebra");
		// 		Grupo LosFibo = new Grupo ("LosFibo", compCant);
		// 			Alumno Bernardino = new Alumno ("Bernardino", "Rivas", 30987654, 21);
		// 				Bernardino.addPalabras("matematicas");
		// 			Alumno Jose = new Alumno ("Jose", "Paso", 33322112, 19);
		// 				Jose.addPalabras("problemas");
		// 			Alumno Isaac = new Alumno ("Isaac", "Newton", 12343565, 30);
		// 				Isaac.addPalabras("sucesiones");
					
		// 	LosFibo.AddElemento(Bernardino);
		// 	LosFibo.AddElemento(Jose);
		// 	LosFibo.AddElemento(Isaac);
			
		// 	Mateados.AddElemento(Julio);
		// 	Mateados.AddElemento(Juan);
			
		// 	OlimpiadasMatematicas.AddElemento(Mateados);
		// 	OlimpiadasMatematicas.AddElemento(LosFibo);
			
		// 	OlimpiadasMatematicas.Print();
			
					
		// } catch (Exception e) {
		// 	// TODO: handle exception
		// }
		
	}

}
